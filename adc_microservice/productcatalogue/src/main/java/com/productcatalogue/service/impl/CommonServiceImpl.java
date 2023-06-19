package com.productcatalogue.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcatalogue.dao.DatacenterLocationDao;
import com.productcatalogue.dao.PartnerDao;
import com.productcatalogue.dao.ProductDao;
import com.productcatalogue.model.DatacenterLocationModel;
import com.productcatalogue.model.Partner;
import com.productcatalogue.model.Product;
import com.productcatalogue.service.CommonService;
import com.productcatalogue.utils.ProductOwnerTypeEnum;

@Service
public class CommonServiceImpl implements CommonService {
	
	@Autowired
    private PartnerDao partnerDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private DatacenterLocationDao datacenterLocationDao;

	// Fetch partner product by location
	@Override
	public List<DatacenterLocationModel> getAllPartnerAndProductByLocationId(Long locationId) {
		List<DatacenterLocationModel> dcLocationList = new ArrayList<DatacenterLocationModel>();
		List<Partner> partnerList = new ArrayList<Partner>();
		
		// Get the data center location
		dcLocationList = datacenterLocationDao.getDatacenterLocation(locationId);
		for (DatacenterLocationModel dcLocation: dcLocationList) {
			List<Product> productList = new ArrayList<Product>();
			partnerList = partnerDao.getPartnerMap(null, locationId, null, ProductOwnerTypeEnum.PARTNER.getValue(), null, null, null);
			for(Partner partner: partnerList) {
				// Get the product by partner and location 
				productList = productDao.getProductMap(null, null, dcLocation.getLocationId(), partner.getPartnerId(), null, null, null, null); 
				//partner.setProducts(productList);
			}
			//dcLocation.setPartners(partnerList);
		}
		return dcLocationList;
	}

	// Fetch All Product for the Partner on selected location by partner and location id
	@Override
	public List<Product> getProductByPartnerAndLocationId(Long partnerId, Long locationId) {
		return productDao.getProductMap(null, null, locationId, partnerId, null, null, null, null);
	}
	
}
