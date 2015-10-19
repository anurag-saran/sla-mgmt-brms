package com.redhatbank.brms.tracktrace.rules;

import com.redhatbank.brms.tracktrace.model.*;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;


public class Runner {
	public static void main(String[] args) {
		//Get the KieBase
		EmbeddedKieBaseProvider kbp = new EmbeddedKieBaseProvider();
		KieBase kieBase = kbp.getKieBase();
		
		//Create a Fact
		SLACriteria slCri = new SLACriteria();
		slCri.setSlaCatalogName("NAVProdBSE");
		
		
		//Determine SLA with Drools
		SLACriteria slCriVal = determineSLA(slCri,kieBase);
		
		//Was our values set correctly?
		System.out.println(slCriVal.toString()+":"+slCriVal.getTime()+":"+slCriVal.getPercentage());
	}
	
	private static SLACriteria determineSLA(SLACriteria slCri, KieBase kieBase) {
		//KieSession is an interface to the drools engine
		KieSession kieSession = kieBase.newKieSession();
		kieSession.insert(slCri);
		kieSession.fireAllRules();
		kieSession.dispose();
		return slCri;
	}

}