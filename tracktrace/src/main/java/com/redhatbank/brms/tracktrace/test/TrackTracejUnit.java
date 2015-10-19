package com.redhatbank.brms.tracktrace.test;

import com.redhatbank.brms.tracktrace.model.SLACriteria;
import com.redhatbank.brms.tracktrace.rules.RuleHandler;
public class TrackTracejUnit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RuleHandler rH = new RuleHandler();
		SLACriteria slaCriteria = new SLACriteria("MT",1.2,1,1);
		rH.readMasterCatalogDT(slaCriteria);
	}

}
