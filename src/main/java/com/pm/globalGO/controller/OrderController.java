package com.pm.globalGO.controller;
import com.pm.globalGO.domain.Orderr;
import com.pm.globalGO.domain.OrderrRepository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class OrderController{
	
	@Autowired
	private OrderrRepository orderRepository;
	
	@RequestMapping("/saveOrder")
	public void saveOrder() {
		Date time = new Date();
		Orderr order = new Orderr();
		order.setState("finish");
		order.setAddress("ass");
		order.setAddressee("assee");
		order.setContact("ef");
		order.setTime(time);
		order.setUserID("123");
		orderRepository.save(order);
	}
	

	@RequestMapping("/getOrder")
	public List<Orderr> getAllOrder(){
		return orderRepository.findAll();
	}
}
