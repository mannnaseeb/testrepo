package com.productcatalogue.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "datacenter_location")
public class DatacenterLocationEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long locationId;

	@Column(name = "REGION_ID")
	private Long regionId;

	@Column(name = "COUNTRY_ID")
	private Long countryId;

	@Column(name = "METRO_ID")
	private Long metroId;

	@Column(name = "CAMPUS_ID")
	private Long campusId;

	@Column(name = "LATITUDE")
	private Float latitude;

	@Column(name = "LONGITUDE")
	private Float longitude;

	@Column(name = "IS_UTILITY_POWER")
	private String isUtilityPower;

	@Column(name = "AMOUNT_OF_UTILTIY_POWER")
	private String amountOfUtiltiyPower;

	@Column(name = "CONSTRUCTION_STATUS")
	private String constructionStatus;

	@Column(name = "STARTING_CONSTRUCTION_LEVEL")
	private String startingConstructionLevel;

	@Column(name = "IS_ACTIVE")
	private Integer isActive;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "CREATED_ON")
	private Date createdOn;

	@Column(name = "MODIFIED_BY")
	private String modifiedBy;

	@Column(name = "MODIFIED_ON")
	private Date modifiedOn;

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
