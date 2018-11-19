package com.pm.globalGO.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(CartPK.class)
public class Cart implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private String userID;
	
	@Id
	@GeneratedValue
	private Long commodityID;
	
	@Column(nullable = false)
	private int cartNumber;
	
	public Cart() {
		super();
	}
	
	public Cart(String userID,Long commodityID,int cartNumber)
	{
		super();
		this.userID=userID;
		this.commodityID=commodityID;
		this.cartNumber=cartNumber;
	}
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
	public int getCartNumber() {
		return cartNumber;
	}
	public void setCartNumber(int cartNumber) {
		this.cartNumber=cartNumber;
	}
}
