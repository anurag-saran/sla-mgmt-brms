package com.redhatbank.brms.tracktrace.rules;

import com.redhatbank.brms.tracktrace.service.TrackTraceService;
import com.redhatbank.brms.tracktrace.database.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.tools.ant.taskdefs.Sleep;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;

import com.redhatbank.brms.tracktrace.model.*;

public class RuleHandler {
	//private static final Logger LOG = LoggerFactory.getLogger(RulesTest.class);

	private static DecisionTableKieBaseProvider dtableManager = new DecisionTableKieBaseProvider();
	
	
	
	
	public SLACriteria readMasterCatalogDT(SLACriteria slaCriteria){
	KieBase kieBase = dtableManager.getKieBase();
	KieSession session = kieBase.newKieSession();

	session.insert(slaCriteria);
	session.fireAllRules();
	System.out.println("Values Read From Decision Table:"+slaCriteria.getPercentage() + slaCriteria.getTime());
	return slaCriteria;
	}
	
	
	
	
//	public void PeriodicallyCheckDTAndCompare(){
//		SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
//		
//		//String str = sdf.format(new Date());
//		for(;;)
//		{
//			for(int i =0; i<=TrackTraceDataBase.getTrackTrace().size(); i++) {
//				
//			
//				try{
//					
//					
//					if (slaCriteria.getTime() == sdf.format(new Date())){
//						System.out.println("Current Time Matched: Update TrackTrace");
//						SLACriteria.class.
//					}
//					Thread.sleep(2000);
//		        }
//		        catch (Exception e)
//		        {
//		            e.printStackTrace();
//		        }
//			}
//			
//			
//		}
//	}
}
