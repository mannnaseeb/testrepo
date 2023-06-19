
package com.productcatalogue.model;

import lombok.Data;

public class Partner {
	
	private Long partnerId;
	private String name;
	private String shortDescription;
	private String longDescription;
	private Long subCategoryId;
	private String subCategoryName;
	private String websiteUrl;
	private String image;
	private boolean is_active;
	private PartnerCategory category;
	private PartnerSubCatgeory subCategory;
	private Address address;
	private PrimaryContact primaryContact;
	
	public Long getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getLongDescription() {
		return longDescription;
	}
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	public PartnerCategory getCategory() {
		return category;
	}
	public void setCategory(PartnerCategory category) {
		this.category = category;
	}
	public PartnerSubCatgeory getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(PartnerSubCatgeory subCategory) {
		this.subCategory = subCategory;
	}
	public Long getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(Long subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	public String getSubCategoryName() {
		return subCategoryName;
	}
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	public String getWebsiteUrl() {
		return websiteUrl;
	}
	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public PrimaryContact getPrimaryContact() {
		return primaryContact;
	}
	public void setPrimaryContact(PrimaryContact primaryContact) {
		this.primaryContact = primaryContact;
	}
	public boolean isIs_active() {
		return is_active;
	}
	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	
}
