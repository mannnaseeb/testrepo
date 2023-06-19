package com.productcatalogue.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcatalogue.dao.ProductOwnerTypeAPIRepository;
import com.productcatalogue.entity.ProductOwnerTypeEntity;
import com.productcatalogue.service.ProductOwnerTypeAPIService;

@Service
public class ProductOwnerTypeAPIServiceImpl implements ProductOwnerTypeAPIService{
	
	@Autowired
	private ProductOwnerTypeAPIRepository productOwnerTypeAPIRepository;

	// Get the list of product owner 
	@Override
	public List<ProductOwnerTypeEntity> getAllProductOwnerType() {
		return productOwnerTypeAPIRepository.getAllProductOwnerType();
	}
}
