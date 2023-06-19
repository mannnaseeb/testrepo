package com.loyaltyservice.model;

import java.util.Date;

public class Redemptions {
	
	private Long redemptionId;
	private Long customerId;
	private Long partnerIds;
	private String voucherOpted;
	private Long pointRedeem;
	private String status;
	private String comments;
	private String createdBy;
	private Date createdOn;
	private Transaction transaction;
	
	public Long getRedemptionId() {
		return redemptionId;
	}
	public void setRedemptionId(Long redemptionId) {
		this.redemptionId = redemptionId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getPartnerIds() {
		return partnerIds;
	}
	public void setPartnerIds(Long partnerIds) {
		this.partnerIds = partnerIds;
	}
	public String getVoucherOpted() {
		return voucherOpted;
	}
	public void setVoucherOpted(String voucherOpted) {
		this.voucherOpted = voucherOpted;
	}
	public Long getPointRedeem() {
		return pointRedeem;
	}
	public void setPointRedeem(Long pointRedeem) {
		this.pointRedeem = pointRedeem;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	
}
