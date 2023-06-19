package com.productcatalogue.service;

import java.util.List;

import com.productcatalogue.model.DatacenterLocationModel;
import com.productcatalogue.model.Product;

public interface CommonService {
	
	// Fetch partner product by location
	List<DatacenterLocationModel> getAllPartnerAndProductByLocationId(Long locationId);
	
	// Fetch All Product for the Partner on selected location by partner and location id
	List<Product> getProductByPartnerAndLocationId(Long partnerId, Long locationId);
}
