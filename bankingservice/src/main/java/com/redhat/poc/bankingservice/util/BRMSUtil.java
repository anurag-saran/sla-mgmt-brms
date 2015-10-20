package com.redhat.poc.bankingservice.util;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import org.drools.core.time.impl.PseudoClockScheduler;
import org.kie.api.KieServices;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.KieSessionConfiguration;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.api.runtime.conf.ClockTypeOption;
import org.kie.api.time.SessionClock;
import org.kie.internal.KnowledgeBaseFactory;

import com.redhat.poc.banking.slamgmtrules.BatchJobInfo;
import com.redhat.poc.banking.slamgmtrules.BatchJobUpdate;

@Singleton
public class BRMSUtil implements Serializable {

	private static final long serialVersionUID = 1562882558996412866L;

	private KieContainer kContainer = null;
    
    public BRMSUtil() {	    
    	
    	KieServices kServices = KieServices.Factory.get();

			ReleaseId releaseId = kServices.newReleaseId( "com.redhat.poc.banking", "SLAMgmtRules", "LATEST" );

			kContainer = kServices.newKieContainer( releaseId );

			/*KieScanner kScanner = kServices.newKieScanner( kContainer );


			// Start the KieScanner polling the maven repository every 10 seconds
			System.out.println("Starting KieScanner...");
			System.out.println();
			kScanner.start( 10000L );
			System.out.println("Started KieScanner sucessfully...");
			System.out.println();*/
    }


    
    public StatelessKieSession getStatelessSession() {

        return kContainer.newStatelessKieSession();

    }

    /*
     * KieSession is the new StatefulKnowledgeSession from BRMS 5.3.
     */
    public KieSession getStatefulSession() {

        return kContainer.newKieSession();

    }
    
    public static void main(String[] args) {
    	
    	BRMSUtil bUtil = new BRMSUtil();
    	
    	/*KieSessionConfiguration conf = KnowledgeBaseFactory.newKnowledgeSessionConfiguration();
        conf.setOption( ClockTypeOption.get( "pseudo" ) );
    	*/
        KieServices kServices = KieServices.Factory.get();
        
        ReleaseId releaseId = kServices.newReleaseId( "com.redhat.poc.banking", "SLAMgmtRules", "LATEST" );

        KieContainer kContainer = kServices.newKieContainer( releaseId );

        //KieSession kSession = kContainer.newKieSession(conf);
        
        KieSession kSession = kContainer.newKieSession();
    	
    	BatchJobInfo info = new BatchJobInfo();
    	info.setTotalTransactions(100);
    	info.setNoOfTransProcessed(0);
    	info.setTransactionType("TX1");
    	info.setPctTransComplete(0.0);
    	
    	kSession.insert(info);
    	
    	BatchJobUpdate update1 = new BatchJobUpdate();
    	update1.setTransactionType("TX1");
    	update1.setNoOfTransProcessed(50);
    	
    	kSession.insert(update1);
    	
    	kSession.fireAllRules();
    	//kSession.fireUntilHalt();
        
    	System.out.println(info.getTransactionType());
    	System.out.println(info.getNoOfTransProcessed());
    	System.out.println(info.getPctTransComplete());
    	
/*    	try {
			Thread.sleep(25000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	kSession.fireAllRules();*/
    	
    	kSession.fireUntilHalt();
    	
    /*
    	 PseudoClockScheduler timeService = ( PseudoClockScheduler ) kSession.<SessionClock>getSessionClock();
         timeService.advanceTime( new Date().getTime(), TimeUnit.MILLISECONDS );
    */
    	
    	/*		
    	timeService.advanceTime( 30, TimeUnit.SECONDS );
    	
    	kSession.fireAllRules();*/
    	
    	kSession.dispose();
    	
    }
    
  
}
