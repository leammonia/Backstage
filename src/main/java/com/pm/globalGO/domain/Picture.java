package com.pm.globalGO.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Picture implements Serializable{
	
	@Id
	@GeneratedValue
	private Long pictureIndex;
	
	@Column(nullable = false)
	private String pictureURL;

	public Picture() {
		super();
	}
	
	public Picture(Long pictureIndex,String pictureURL) {
		super();
		this.pictureIndex=pictureIndex;
		this.pictureURL=pictureURL;
	}
	public Long getPictureIndex() {
		return pictureIndex;
	}
	public void setPictureIndex(Long pictureIndex) {
		this.pictureIndex=pictureIndex;
	}
	public String getPictureURL() {
		return pictureURL;
	}
	public void setPictureURL(String pictureURL) {
		this.pictureURL=pictureURL;
	}
}
