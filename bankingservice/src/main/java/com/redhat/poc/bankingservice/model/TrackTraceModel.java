package com.redhat.poc.bankingservice.model;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class TrackTraceModel {
    
	private String transactionType;
    private int totalTransactions ;
    private int noOfTransProcessed ;
    private int successfullTrans ;
    
    public TrackTraceModel(){
    	
    }
    public TrackTraceModel(String transactionType, int totalTransactions,
			int noOfTransProcessed, int successfullTrans,
			int errorTransactions, String logMessage) {
		//super();
		this.transactionType = transactionType;
		this.totalTransactions = totalTransactions;
		this.noOfTransProcessed = noOfTransProcessed;
		this.successfullTrans = successfullTrans;
		this.errorTransactions = errorTransactions;
		this.logMessage = logMessage;
	}
	private int errorTransactions; 
    private String logMessage;
    
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public int getTotalTransactions() {
		return totalTransactions;
	}
	public void setTotalTransactions(int totalTransactions) {
		this.totalTransactions = totalTransactions;
	}
	public int getNoOfTransProcessed() {
		return noOfTransProcessed;
	}
	public void setNoOfTransProcessed(int noOfTransProcessed) {
		this.noOfTransProcessed = noOfTransProcessed;
	}
	public int getSuccessfullTrans() {
		return successfullTrans;
	}
	public void setSuccessfullTrans(int successfullTrans) {
		this.successfullTrans = successfullTrans;
	}
	public int getErrorTransactions() {
		return errorTransactions;
	}
	public void setErrorTransactions(int errorTransactions) {
		this.errorTransactions = errorTransactions;
	}
	public String getLogMessage() {
		return logMessage;
	}
	public void setLogMessage(String logMessage) {
		this.logMessage = logMessage;
	}
}
