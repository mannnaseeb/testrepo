package com.loyaltyservice.service.impl;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loyaltyservice.model.Transaction;
import com.loyaltyservice.service.LoyaltyRuleService;

@Service
public class LoyaltyRuleServiceImpl implements LoyaltyRuleService {
	
	@Autowired
    private KieContainer kieContainer;

	@Override
	public Transaction loyaltyRule(Transaction transaction) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("transaction", transaction);
        kieSession.insert(transaction);
        kieSession.fireAllRules();
        kieSession.dispose();
		return transaction;
	}
	

}
