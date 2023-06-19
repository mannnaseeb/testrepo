package com.productcatalogue.model;

import java.util.List;

import lombok.Data;

@Data
public class PartnerProductLocationRequest {
	private Partner partner;
	private List<ProductLocationRequest> productLocation;
	
	public Partner getPartner() {
		return partner;
	}
	public void setPartner(Partner partner) {
		this.partner = partner;
	}
	public List<ProductLocationRequest> getProductLocation() {
		return productLocation;
	}
	public void setProductLocation(List<ProductLocationRequest> productLocation) {
		this.productLocation = productLocation;
	}
	
	
}
