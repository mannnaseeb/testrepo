package com.loyaltyservice.model;

import lombok.Data;

@Data
public class EarnLoyaltyPoint {
	
	private Long loyaltyPoint;
	private String loyaltyName;
	public Long getLoyaltyPoint() {
		return loyaltyPoint;
	}
	public void setLoyaltyPoint(Long loyaltyPoint) {
		this.loyaltyPoint = loyaltyPoint;
	}
	public String getLoyaltyName() {
		return loyaltyName;
	}
	public void setLoyaltyName(String loyaltyName) {
		this.loyaltyName = loyaltyName;
	}
	
	
	
}
