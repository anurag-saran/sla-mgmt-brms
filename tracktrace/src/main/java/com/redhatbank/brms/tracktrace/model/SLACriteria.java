package com.redhatbank.brms.tracktrace.model;

public class SLACriteria {
	  
	   private String slaCatalogName;
	   private double percentage;
	   private int time;
	   private int type;
	public java.lang.String getSlaCatalogName() {
		return slaCatalogName;
	}
	public void setSlaCatalogName(java.lang.String slaCatalogName) {
		this.slaCatalogName = slaCatalogName;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public SLACriteria(String slaCatalogName, double percentage, int i,
			int type) {
		super();
		this.slaCatalogName = slaCatalogName;
		this.percentage = percentage;
		this.time = i;
		this.type = type;
	}
	public SLACriteria(){}
}
