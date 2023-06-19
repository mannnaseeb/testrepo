package com.productcatalogue.model;

import lombok.Data;

@Data
public class ProductLocationRequest {
	private Long productId;
	private String productName;
	private Long productFamilyId;
	private String productFamilyName;
	private Long dataCenterLocationId;
	private String dataCenterLocationName;
	private Long partnerId;
	private String partnerName;
	private String status;//Approved, Rejected, Approval Pending
	private Boolean isActive;
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getProductFamilyId() {
		return productFamilyId;
	}
	public void setProductFamilyId(Long productFamilyId) {
		this.productFamilyId = productFamilyId;
	}
	public String getProductFamilyName() {
		return productFamilyName;
	}
	public void setProductFamilyName(String productFamilyName) {
		this.productFamilyName = productFamilyName;
	}
	public Long getDataCenterLocationId() {
		return dataCenterLocationId;
	}
	public void setDataCenterLocationId(Long dataCenterLocationId) {
		this.dataCenterLocationId = dataCenterLocationId;
	}
	public String getDataCenterLocationName() {
		return dataCenterLocationName;
	}
	public void setDataCenterLocationName(String dataCenterLocationName) {
		this.dataCenterLocationName = dataCenterLocationName;
	}
	public Long getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}
	public String getPartnerName() {
		return partnerName;
	}
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	
	
}
