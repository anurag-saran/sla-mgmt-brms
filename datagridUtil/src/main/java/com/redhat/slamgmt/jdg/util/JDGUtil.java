package com.redhat.slamgmt.jdg.util;

import com.redhat.poc.banking.slamgmtrules.SLAMessage;
import com.redhat.slamgmt.jdg.services.JDGDataService;

public class JDGUtil {

	public static void main(String[] args) {
		
		JDGDataService service = JDGDataService.getJDGDataService();			

//		SLAMessage message1 = new SLAMessage();
//		message1.setMessage("SLA Missed");
//		message1.setTransactionType("TX1");
//		
//		service.writeMessage(message1);
		
		SLAMessage message2 = service.readSLAMessage("TX2");
		
		System.out.println(message2.getMessage());
		

	}
	


}
