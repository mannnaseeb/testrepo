package com.loyaltyservice.model;

import java.io.Serializable;

public class LeaderBoardPoint implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long rank;
	private String customerId;
	private Long partnerIds;
	private String partnerName;
	private Transaction transaction;
	private Redemptions redemptions;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getRank() {
		return rank;
	}
	public void setRank(Long rank) {
		this.rank = rank;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getPartnerName() {
		return partnerName;
	}
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}
	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	public Long getPartnerIds() {
		return partnerIds;
	}
	public void setPartnerIds(Long partnerIds) {
		this.partnerIds = partnerIds;
	}
	public Redemptions getRedemptions() {
		return redemptions;
	}
	public void setRedemptions(Redemptions redemptions) {
		this.redemptions = redemptions;
	}
	
}
