package com.pm.globalGO.domain;

import java.io.Serializable;
public class Order_CommodityPK implements Serializable {
	private Long orderID;
	private Long commodityID;
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
}
