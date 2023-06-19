package com.loyaltyservice.model;

public class Rule {
	private Long id;
	private String name;
	private String description;
	private String ruleCalc;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRuleCalc() {
		return ruleCalc;
	}
	public void setRuleCalc(String ruleCalc) {
		this.ruleCalc = ruleCalc;
	}
	
	
}
