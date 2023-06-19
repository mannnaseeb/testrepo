package com.productcatalogue.model;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DatacenterLocationModel {
	private Long locationId;
	private String region;
	private String country;
	private String metro;
	private String campus;
	private String latitude;
	private String longitude;
	private String isUtilityPower;
	private String amountOfUtilityPower;
	private String construction_status;
	private String starting_construction_level;
	//private List<Partner> partners;
	public Long getLocationId() {
		return locationId;
	}
	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getMetro() {
		return metro;
	}
	public void setMetro(String metro) {
		this.metro = metro;
	}
	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getIsUtilityPower() {
		return isUtilityPower;
	}
	public void setIsUtilityPower(String isUtilityPower) {
		this.isUtilityPower = isUtilityPower;
	}
	public String getAmountOfUtilityPower() {
		return amountOfUtilityPower;
	}
	public void setAmountOfUtilityPower(String amountOfUtilityPower) {
		this.amountOfUtilityPower = amountOfUtilityPower;
	}
	public String getConstruction_status() {
		return construction_status;
	}
	public void setConstruction_status(String construction_status) {
		this.construction_status = construction_status;
	}
	public String getStarting_construction_level() {
		return starting_construction_level;
	}
	public void setStarting_construction_level(String starting_construction_level) {
		this.starting_construction_level = starting_construction_level;
	}
}
