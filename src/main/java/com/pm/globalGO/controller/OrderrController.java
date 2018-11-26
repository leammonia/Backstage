package com.pm.globalGO.controller;
import com.pm.globalGO.domain.Orderr;
import com.pm.globalGO.domain.OrderrRepository;
import com.pm.globalGO.domain.User;
import com.pm.globalGO.domain.UserRepository;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;
import com.pm.globalGO.controller.ResultEnum;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class OrderrController{
	
	@Autowired
	private static OrderrRepository orderrRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public static Orderr findByOrderID(Long orderid) {
		return orderrRepository.findById(orderid).get();
	}
	
	public void saveOrderr(Orderr order) {
		orderrRepository.save(order);
	}
	
	
	
	@ResponseBody
	@PutMapping(path = "/v1/admin/order/{orderid}")
	public String modifyOrderState(
			@PathVariable(name = "orderid",required = false) Long orderid,
			@RequestBody String jsonstr//body中的json
			) 
			{
		
		//将string转化成JSONObject并获取键值
		JSONObject jsonObject = JSONObject.parseObject(jsonstr);
		String token = jsonObject.getString("token");
		String state = jsonObject.getString("state");

		//获取用户
		//String userId = UserController.getUserIDByToken(token);
		String userID="2";
		User user=userRepository.findById(userID).get();
		
		//响应json
		JSONObject jsonRet = new JSONObject();
		
		if (user.getType().equals("admin")) {
			Orderr order = findByOrderID(orderid);
			order.setState(state);
			saveOrderr(order);
			
			//在响应json中加入错误信息
			jsonRet.put("code",0);
			jsonRet.put("errMessage","");
		}
		else {
			//在响应json中加入错误信息
			jsonRet.put("code",-1);
			jsonRet.put("errMessage","failed");
		}
			
		return jsonRet.toJSONString();
	}
}

