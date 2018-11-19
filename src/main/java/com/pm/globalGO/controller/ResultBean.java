package com.pm.globalGO.controller;


public class ResultBean {

	private int code;
	private String errMessage;
	private Object data;
	
	ResultBean(){
		super();
	}
	
	ResultBean(int code, String errMessage){
		super();
		this.code=code;
		this.errMessage=errMessage;
	}
	
	void setCode(int code) {
		this.code=code;
	}
	int getCode() {
		return this.code;
	}
	
	void setErrMessage(String errMessage) {
		this.errMessage=errMessage;
	}
	String getErrMessage() {
		return this.errMessage;
	}
	Object getData(){
		return data;
	}
} 