package com.productcatalogue.model;

import java.util.List;

import lombok.Data;

/**
 * Data would be return with no.unique location of a Partner and unique product owned by Partner at all Unique Locations
 * along with Product and Location mapping
 * @author praveen.gairola
 *
 */
@Data
public class PartnerProductLocation {
	
	public Long getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(Long totalcount) {
		this.totalcount = totalcount;
	}
	private Partner partner;
	private List<ProductLocationRequest> productLocation;
	private Long locationCount;
	private Long productCount;
	private Long totalcount;
	
	
	public Partner getPartner() {
		return partner;
	}
	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public Long getLocationCount() {
		return locationCount;
	}
	public void setLocationCount(Long locationCount) {
		this.locationCount = locationCount;
	}
	public Long getProductCount() {
		return productCount;
	}
	public void setProductCount(Long productCount) {
		this.productCount = productCount;
	}
	public List<ProductLocationRequest> getProductLocation() {
		return productLocation;
	}
	public void setProductLocation(List<ProductLocationRequest> productLocation) {
		this.productLocation = productLocation;
	}
	
	
}
