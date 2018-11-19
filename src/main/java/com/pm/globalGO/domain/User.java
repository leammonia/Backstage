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
	private String userID;
	
	@Column(nullable = false)
	private String nickname;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String userPicture;
	
	@Column(nullable = false)
	private double balance;
	
	@Column(nullable = false)
	private String type;
	
	public User() {
		super();
	}
	public User(String userID,String nickname,String password,String userPicture,double balance,String type) {
		super();
		this.userID=userID;
		this.nickname=nickname;
		this.password=password;
		this.userPicture=userPicture;
		this.balance=balance;
		this.type=type;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID=userID;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type=type;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance=balance;
	}
}
