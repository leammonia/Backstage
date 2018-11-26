package com.pm.globalGO.controller;

import java.io.Serializable;

import javax.persistence.Entity;


public class ResultBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int code;
	private String errMessage;
	private Object data;
	
	ResultBean(){
		super();
	}
	
	ResultBean(ResultEnum resultEnum){
		super();
		this.code=resultEnum.getCode();
		this.errMessage=resultEnum.getMsg();
		this.data=null;
	}
	
	ResultBean(ResultEnum resultEnum, Object data){
		super();
		this.code=resultEnum.getCode();
		this.errMessage=resultEnum.getMsg();
		this.data=data;
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
	
	void setDate(Object data) {
		this.data=data;
	}
	
	Object getData(){
		return data;
	}
} 