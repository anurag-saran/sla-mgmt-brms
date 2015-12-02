/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.redhat.slamgmt.jdg;

import javax.annotation.PreDestroy;

import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;

import com.redhat.poc.banking.slamgmtrules.SLAMessage;




public class MyRemoteCacheManagerProvider {

	public static final String CACHE_NAME = "slaMessageCache";
	
	
	private RemoteCacheManager cacheManager = null;
	
	//remote caches
	private RemoteCache<String, SLAMessage> slaMessageCache = null;
	
	
	public MyRemoteCacheManagerProvider() {

		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.addServer().host("localhost").port(Integer.parseInt("11322"));
		cacheManager = new RemoteCacheManager(builder.build());
		
		//remote caches
		slaMessageCache = cacheManager.getCache(CACHE_NAME);
				
		
	}
	
	

	public RemoteCacheManager getCacheManager() {
		return cacheManager;
	}



	public RemoteCache<String, SLAMessage> getSlaMessageCache() {
		return slaMessageCache;
	}



	
	
}
