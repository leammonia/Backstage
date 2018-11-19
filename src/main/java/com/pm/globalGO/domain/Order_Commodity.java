package com.pm.globalGO.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(Order_CommodityPK.class)
public class Order_Commodity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long orderID;
	
	@Id
	@GeneratedValue
	private Long commodityID;
	
	@Column(nullable = false)
	private double transactionPrice;
	
	@Column(nullable = false)
	private int transactionNumber;

	public Order_Commodity() {
		super();
	}
	public Order_Commodity(Long orderID,Long commodityID,double transactionPrice,int transactionNumber) {
		super();
		this.orderID=orderID;
		this.commodityID=commodityID;
		this.transactionPrice=transactionPrice;
		this.transactionNumber=transactionNumber;
	}
	public Long getOrderID() {
		return orderID;
	}
	public void setOrderID(Long orderID) {
		this.orderID=orderID;
	}
	public Long getCommodityID() {
		return commodityID;
	}
	public void setCommodityID(Long commodityID) {
		this.commodityID=commodityID;
	}
	public double getTransactionPrice() {
		return transactionPrice;
	}
	public void setTransactionPrice(double transactionPrice) {
		this.transactionPrice=transactionPrice;
	}
	public int getTransactionNumber() {
		return transactionNumber;
	}
	public void setTransactionNumber(int transactionNumber) {
		this.transactionNumber=transactionNumber;
	}
}
