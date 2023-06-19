package com.loyaltyservice.model;

import java.util.Date;

public class RedemptionResponse {
	
	private String partnerName;
	private String primaryContact;
	private String voucherOpted;
	private Long pointsRedeemed;
	private Long pointsRedeem;
	private Date requestDate;
	private String action;
	
	public String getPartnerName() {
		return partnerName;
	}
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}
	public String getPrimaryContact() {
		return primaryContact;
	}
	public void setPrimaryContact(String primaryContact) {
		this.primaryContact = primaryContact;
	}
	public String getVoucherOpted() {
		return voucherOpted;
	}
	public void setVoucherOpted(String voucherOpted) {
		this.voucherOpted = voucherOpted;
	}
	public Long getPointsRedeem() {
		return pointsRedeem;
	}
	public void setPointsRedeem(Long pointsRedeem) {
		this.pointsRedeem = pointsRedeem;
	}
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Long getPointsRedeemed() {
		return pointsRedeemed;
	}
	public void setPointsRedeemed(Long pointsRedeemed) {
		this.pointsRedeemed = pointsRedeemed;
	}
	
	
	
}
