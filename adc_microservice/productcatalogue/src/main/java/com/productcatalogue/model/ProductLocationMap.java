package com.productcatalogue.model;

import lombok.Data;

@Data
public class ProductLocationMap {

	private DatacenterLocationModel location;
	private Partner partner;
	private Product product;
	private ProductFamily family;
	public DatacenterLocationModel getLocation() {
		return location;
	}
	public void setLocation(DatacenterLocationModel location) {
		this.location = location;
	}
	public Partner getPartner() {
		return partner;
	}
	public void setPartner(Partner partner) {
		this.partner = partner;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public ProductFamily getFamily() {
		return family;
	}
	public void setFamily(ProductFamily family) {
		this.family = family;
	}
	
	
	
}
