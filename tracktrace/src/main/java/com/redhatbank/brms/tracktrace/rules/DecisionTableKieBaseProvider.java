package com.redhatbank.brms.tracktrace.rules;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.Message;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;

public class DecisionTableKieBaseProvider {
	private KieContainer kieContainer = null;

	public KieBase getKieBase() {
		return kieContainer.getKieBase();
	}

	public DecisionTableKieBaseProvider() {
		KieServices kieServices = KieServices.Factory.get();
		KieRepository kieRepository = kieServices.getRepository();
		KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
		
		addResource(kieFileSystem, "com.redhatbank.brms.tracktrace.model.SLACriteria.gdst");


		KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
		kieBuilder.buildAll();
		for (Message message : kieBuilder.getResults().getMessages()) {
			System.out.println(message);
		}
		kieContainer = kieServices.newKieContainer(kieRepository.getDefaultReleaseId());
	}
	
	
	private void addResource(KieFileSystem kieFileSystem, String name) {
		kieFileSystem.write("src/main/resources/" + name, ResourceFactory .newClassPathResource(name));

	}

}
