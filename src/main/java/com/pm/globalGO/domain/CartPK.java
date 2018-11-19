package com.pm.globalGO.domain;

import java.io.Serializable;

public class CartPK implements Serializable{

	private String userID;
	private Long commodityID;
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID=userID;
	}
	public Long getCommodityID() {
		return commodityID;
	}
	public void setCommodityID(Long commodityID) {
		this.commodityID=commodityID;
	}
}
