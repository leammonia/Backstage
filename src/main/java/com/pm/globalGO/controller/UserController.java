package com.pm.globalGO.controller;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.alibaba.fastjson.JSONObject;
import com.pm.globalGO.domain.Orderr;
import com.pm.globalGO.domain.User;
import com.pm.globalGO.domain.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController{
	
	private static Map<Integer,String> tokenMap = new HashMap<Integer,String>();
	private static Map<Integer,Date> tokenTime = new HashMap<Integer,Date>();
	private static int sysAdminToken;
	
	private static final int max_token=1000000;
	private static final long max_validity_interval=12 * 60 * 60 * 1000;
	
	@Autowired
	private UserRepository userRepository;
	
	
	void saveUser(User user) {
		userRepository.save(user);
	}
	
	
	String getUserIDByToken(int token) {
		return tokenMap.get(token);
	}
	
	String hash(String password) {
		StringBuilder ret = new StringBuilder("");
		for (int k=1;k<=20;k++) {
			int t=0;
			for (int i=0;i<password.length();i++) {
				t = t * k + password.charAt(i);
			}	
			if (t<0)
				t=-t;
			ret.append((char)((int)'a'+t%26));
		}
		return ret.toString();
	}
	
	int setTokenForUserID(String userID) {
		Date nowTime=new Date();
		Random rand=new Random();
		int newToken=rand.nextInt(max_token);
		while (tokenMap.get(newToken)!=null && newToken!=sysAdminToken) {
			if (newToken == sysAdminToken) {
				newToken = rand.nextInt(max_token);
				continue;
			}
			Date t = tokenTime.get(newToken);
			long interval = nowTime.getTime()-t.getTime();
			if (interval > max_validity_interval) {
				break;
			}else {
				newToken=rand.nextInt(max_token);
			}
		}
		tokenMap.put(newToken, userID);
		tokenTime.put(newToken,nowTime);
		return newToken;
	}
	
	int setTokenForSysAdmin() {
		Date nowTime=new Date();
		Random rand=new Random();
		int newToken=rand.nextInt(max_token);
		while (tokenMap.get(newToken)!=null) {
			Date t = tokenTime.get(newToken);
			long interval = nowTime.getTime()-t.getTime();
			if (interval > max_validity_interval) {
				break;
			}else {
				newToken=rand.nextInt(max_token);
			}
		}
		sysAdminToken=newToken;
		tokenTime.put(newToken,nowTime);
		return newToken;
	}
	

	@ResponseBody
	@PostMapping(path = "/v1/register")
	public String register(@RequestBody String jsonstr) {
		JSONObject jsonObject = JSONObject.parseObject(jsonstr);
		String userID = jsonObject.getString("userID");
		String password = jsonObject.getString("password");	
		JSONObject ret = new JSONObject();
		User user=userRepository.findByUserid(userID);
		if (user==null) {
			String hashPassword = hash(password);
			User newUser=new User(userID,"User"+userID,hashPassword,"",0,"user");
			saveUser(newUser);
			int newToken=setTokenForUserID(userID);
			ret.put("code", 0);
			ret.put("errMessage","");
			ret.put("token",newToken);
		}else {
			ret.put("code", -1);
			ret.put("errMessage","Existing userID");
			ret.put("token",0);
		}
		return ret.toJSONString();
	}
	
	@ResponseBody
	@PostMapping(path = "/v1/login")
	public String login(@RequestBody String jsonstr) {
		JSONObject jsonObject = JSONObject.parseObject(jsonstr);
		String userID = jsonObject.getString("userID");
		String password = jsonObject.getString("password");
		JSONObject ret = new JSONObject();
		User user=userRepository.findByUserid(userID);
		String hashPassword = hash(password);
		if (user!=null && user.getPassword().equals(hashPassword)) {
				int newToken=setTokenForUserID(userID);
				ret.put("code",0);
				ret.put("errMessage","");
				ret.put("token",newToken);
				ret.put("unfinishedCount",0);
				JSONObject userInfo = new JSONObject();
				userInfo.put("id", user.getUserid());
				userInfo.put("avatar", user.getUserpicture());
				userInfo.put("nickname",user.getNickname());
				userInfo.put("type", user.getType());
				userInfo.put("balance",user.getBalance());
				ret.put("userInfo", userInfo);
		}else {
			ret.put("code",-1);
			ret.put("errMessage","failde");
		}
		return ret.toJSONString();
	}
	
}
