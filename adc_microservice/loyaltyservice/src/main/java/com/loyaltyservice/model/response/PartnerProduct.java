package com.loyaltyservice.model.response;
public class PartnerProduct{
    public Long partnerId;
    public Long productId;
    public String productName;
    public Long productFamilyId;
    public String productFamilyName;
    public Long dataCenterLocationId;
    public String dataCenterLocationName;
    public boolean published;
    public boolean active;
	public Long getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}
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
	public boolean isPublished() {
		return published;
	}
	public void setPublished(boolean published) {
		this.published = published;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
    
    
}