package com.pm.globalGO.controller;
import java.util.Map;

import com.pm.globalGO.domain.User;
import com.pm.globalGO.domain.UserRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

public class UserController implements UserRepository{

	private Map<Integer,String> tokenMap;
	private int sysAdminToken;
	private UserRepository userRepository;
	
	@PostMapping(value="login")
	@ResponseBody
	public ResultBean login(String userID , String password) {
		return null;	
	}
	
	@RequestMapping("/register")
	@ResponseBody
	public ResultBean register() {
		
	}
	
	@RequestMapping("/admin/info")
	@ResponseBody
	public ResultBean getAllData() {
		
	}
	
	@RequestMapping("/admin")
	@ResponseBody
	public ResultBean modifyUserInfo() {
		
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public ResultBean sysModifyUser() {
		
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public ResultBean sysGetInfo() {
		
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public ResultBean sysDeleteUser() {
		
	}
	
	void saveUser(User user) {
		
	}
	
	String getUserIDByToken(int token) {
		return tokenMap.get(token);
	}
	
	Boolean hash(String password) {
		return true;
	}
	
	int setTokenForUserID(String userID) {
		int newToken=tokenMap.size();
		tokenMap.put(newToken, userID);
		return newToken;
	}
	
	int setTokenForSysAdmin() {
		sysAdminToken=tokenMap.size();
		tokenMap.put(sysAdminToken, "");
		return sysAdminToken;
	}
	
	
	
}
