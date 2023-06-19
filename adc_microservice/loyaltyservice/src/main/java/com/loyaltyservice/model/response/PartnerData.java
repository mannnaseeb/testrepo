package com.loyaltyservice.model.response;

import java.util.List;

public class PartnerData{
	
    public Long partnerId;
    public String partnerName;
    public String businessChannelId;
    public String website;
    public String partnerShortDesc;
    public String partnerFullDesc;
    public Long categoryId;
    public String categoryName;
    public String subCategoryId;
    public String subCategoryname;
    public String imageName;
    public String imageBase64;
    public Long registrationId;
    public String partnerStatus;
    public PartnerAddress partnerAddress;
    public String partnerResource;
    public List<PartnerProduct> partnerProducts;
    public Contact contact;
    
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
	public String getBusinessChannelId() {
		return businessChannelId;
	}
	public void setBusinessChannelId(String businessChannelId) {
		this.businessChannelId = businessChannelId;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getPartnerShortDesc() {
		return partnerShortDesc;
	}
	public void setPartnerShortDesc(String partnerShortDesc) {
		this.partnerShortDesc = partnerShortDesc;
	}
	public String getPartnerFullDesc() {
		return partnerFullDesc;
	}
	public void setPartnerFullDesc(String partnerFullDesc) {
		this.partnerFullDesc = partnerFullDesc;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(String subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	public String getSubCategoryname() {
		return subCategoryname;
	}
	public void setSubCategoryname(String subCategoryname) {
		this.subCategoryname = subCategoryname;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getImageBase64() {
		return imageBase64;
	}
	public void setImageBase64(String imageBase64) {
		this.imageBase64 = imageBase64;
	}
	public Long getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(Long registrationId) {
		this.registrationId = registrationId;
	}
	public String getPartnerStatus() {
		return partnerStatus;
	}
	public void setPartnerStatus(String partnerStatus) {
		this.partnerStatus = partnerStatus;
	}
	public PartnerAddress getPartnerAddress() {
		return partnerAddress;
	}
	public void setPartnerAddress(PartnerAddress partnerAddress) {
		this.partnerAddress = partnerAddress;
	}
	public String getPartnerResource() {
		return partnerResource;
	}
	public void setPartnerResource(String partnerResource) {
		this.partnerResource = partnerResource;
	}
	public List<PartnerProduct> getPartnerProducts() {
		return partnerProducts;
	}
	public void setPartnerProducts(List<PartnerProduct> partnerProducts) {
		this.partnerProducts = partnerProducts;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
    
    
}