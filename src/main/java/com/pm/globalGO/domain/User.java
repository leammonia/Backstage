package com.pm.globalGO.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private String userid;
	
	@Column(nullable = false)
	private String nickname;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String userpicture;
	
	@Column(nullable = false)
	private double balance;
	
	@Column(nullable = false)
	private String type;
	
	public User() {
		super();
	}
	public User(String userid,String nickname,String password,String userpicture,double balance,String type) {
		super();
		this.userid=userid;
		this.nickname=nickname;
		this.password=password;
		this.userpicture=userpicture;
		this.balance=balance;
		this.type=type;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid=userid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname=nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public String getUserpicture() {
		return userpicture;
	}
	public void setUserpicture(String userpicture) {
		this.userpicture=userpicture;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance=balance;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type=type;
	}
}
