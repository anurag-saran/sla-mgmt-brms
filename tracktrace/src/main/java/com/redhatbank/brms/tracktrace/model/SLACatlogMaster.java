package com.redhatbank.brms.tracktrace.model;

import java.util.Date;

public class SLACatlogMaster {
	  
	   private String name;
	   private Date slaExecutionDate;
       private Date slaExpiryDate;
       private String slaType;
       private String status;
   	   private String measurementFrequency;
	   private String activity;
	   private String applicationMenmonic;
       
	   public SLACatlogMaster(){}
	   
       public SLACatlogMaster(String name, Date slaExecutionDate,
			Date slaExpiryDate, String slaType, String status,
			String measurementFrequency, String activity,
			String applicationMenmonic) {
		//super();
		this.name = name;
		this.slaExecutionDate = slaExecutionDate;
		this.slaExpiryDate = slaExpiryDate;
		this.slaType = slaType;
		this.status = status;
		this.measurementFrequency = measurementFrequency;
		this.activity = activity;
		this.applicationMenmonic = applicationMenmonic;
	}

	public String getName() {
		return name;
	}
	   
	public void setName(String name) {
		this.name = name;
	}
	public Date getSlaExecutionDate() {
		return slaExecutionDate;
	}
	public void setSlaExecutionDate(Date slaExecutionDate) {
		this.slaExecutionDate = slaExecutionDate;
	}
	public Date getSlaExpiryDate() {
		return slaExpiryDate;
	}
	public void setSlaExpiryDate(Date slaExpiryDate) {
		this.slaExpiryDate = slaExpiryDate;
	}
	public String getSlaType() {
		return slaType;
	}
	public void setSlaType(String slaType) {
		this.slaType = slaType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMeasurementFrequency() {
		return measurementFrequency;
	}
	public void setMeasurementFrequency(String measurementFrequency) {
		this.measurementFrequency = measurementFrequency;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public String getApplicationMenmonic() {
		return applicationMenmonic;
	}
	public void setApplicationMenmonic(String applicationMenmonic) {
		this.applicationMenmonic = applicationMenmonic;
	}

}
