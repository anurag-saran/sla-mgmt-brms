package com.redhat.slamgmt.jdg.services;

//import javax.inject.Singleton;

import org.infinispan.client.hotrod.RemoteCache;

import com.redhat.poc.banking.slamgmtrules.SLAMessage;
import com.redhat.slamgmt.jdg.MyRemoteCacheManagerProvider;

//@Singleton
public class JDGDataService {

	private static JDGDataService jdgDataService = null;
	
	private MyRemoteCacheManagerProvider remoteCacheManager = null;
	
	public JDGDataService() {
	
		remoteCacheManager = new MyRemoteCacheManagerProvider();
		
	}
	
	public synchronized static JDGDataService getJDGDataService() {
		
		if ( jdgDataService == null ) {
			
			jdgDataService = new JDGDataService();
			
		}
		
		return jdgDataService;
		
	}
	
	public  void writeMessage(SLAMessage slaMessage) {
		
		System.out.println("Start writeMessage()");
		
		RemoteCache<String, SLAMessage> cache = remoteCacheManager.getSlaMessageCache();
		
		String key = slaMessage.getTransactionType();
		
		cache.put(slaMessage.getTransactionType(), slaMessage);
		
		System.out.println("End writeMessage() - " + key + " : " + cache.get(key));
		
	}
	
	public SLAMessage readSLAMessage(String key) {
						
		RemoteCache<String, SLAMessage> cache = remoteCacheManager.getSlaMessageCache();
		
		if ( cache.containsKey(key) ) {
			
			return cache.get(key);
			
		} else {
			
			return null;
			
		}
						
	}
}
