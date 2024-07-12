package com.edubridge.DTHApp.Model1;

import java.sql.PreparedStatement;

public class DTH {
	private int dth_id ;
	 private String dth_name;
	 private int dth_channels;
	 private float dth_price;
	public int getDth_id() {
		return dth_id;
	}
	public void setDth_id(int dth_id) {
		this.dth_id = dth_id;
	}
	public String getDth_name() {
		return dth_name;
	}
	public void setDth_name(String dth_name) {
		this.dth_name = dth_name;
	}
	public int getDth_channels() {
		return dth_channels;
	}
	public void setDth_channels(int dth_channels) {
		this.dth_channels = dth_channels;
	}
	public float getDth_price() {
		return dth_price;
	}
	public void setDth_price(float dth_price) {
		this.dth_price = dth_price;
	}
	public PreparedStatement prepareStatement(String iNSERT) {
		// TODO Auto-generated method stub
		return null;
	}
	
}