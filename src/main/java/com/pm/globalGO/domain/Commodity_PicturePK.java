package com.pm.globalGO.domain;

import java.io.Serializable;
public class Commodity_PicturePK implements Serializable{
	private Long commodityID;
	private int pictureOrder;
	public Long getCommodityID() {
		return commodityID;
	}
	public void setCommodityID(Long commodityID) {
		this.commodityID=commodityID;
	}
	public int getPictureOrder() {
		return pictureOrder;
	}
	public void setPictureOrder(int pictureOrder) {
		this.pictureOrder=pictureOrder;
	}
}
