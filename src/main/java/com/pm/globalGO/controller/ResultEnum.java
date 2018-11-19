package com.pm.globalGO.controller;

public enum ResultEnum {

	SUCCESS(0,"success"),
	FAILURE(1,"failure");
	
	private int code;
	private String msg;
	
	ResultEnum(int code,String msg){
		this.code=code;
		this.msg=msg;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getMsg() {
		return msg;
	}
} 