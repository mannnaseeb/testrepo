package com.productcatalogue.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Location {
	
	private Long regionId;
	private Long countryId;
	private Long metroId;
	private Long campusId;
	private Float latitude;
	private Float longitude;
	private String isUtilityPower;
	private String amountOfUtiltiyPower;
	private String constructionStatus;
	private String startingConstructionLevel;
	private Integer isActive;
	private String createdBy;
	private Date createdOn;
	private String modifiedBy;
	private Date modifiedOn;
	public Long getRegionId() {
		return regionId;
	}
	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}
	public Long getCountryId() {
		return countryId;
	}
	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}
	public Long getMetroId() {
		return metroId;
	}
	public void setMetroId(Long metroId) {
		this.metroId = metroId;
	}
	public Long getCampusId() {
		return campusId;
	}
	public void setCampusId(Long campusId) {
		this.campusId = campusId;
	}
	public Float getLatitude() {
		return latitude;
	}
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	public Float getLongitude() {
		return longitude;
	}
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	public String getIsUtilityPower() {
		return isUtilityPower;
	}
	public void setIsUtilityPower(String isUtilityPower) {
		this.isUtilityPower = isUtilityPower;
	}
	public String getAmountOfUtiltiyPower() {
		return amountOfUtiltiyPower;
	}
	public void setAmountOfUtiltiyPower(String amountOfUtiltiyPower) {
		this.amountOfUtiltiyPower = amountOfUtiltiyPower;
	}
	public String getConstructionStatus() {
		return constructionStatus;
	}
	public void setConstructionStatus(String constructionStatus) {
		this.constructionStatus = constructionStatus;
	}
	public String getStartingConstructionLevel() {
		return startingConstructionLevel;
	}
	public void setStartingConstructionLevel(String startingConstructionLevel) {
		this.startingConstructionLevel = startingConstructionLevel;
	}
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
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
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	
	
}
