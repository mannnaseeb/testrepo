package com.productcatalogue.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcatalogue.dao.PartnerSubCategoryRepository;
import com.productcatalogue.entity.PartnerSubcategoryEntity;
import com.productcatalogue.service.PartnerSubCategoryService;

@Service
public class PartnerSubCategoryServiceImpl implements PartnerSubCategoryService{

	@Autowired
	private PartnerSubCategoryRepository partnerSubCategoryRepository;
	
	// Get the list of partner sub-categories
	@Override
	public List<PartnerSubcategoryEntity> getAllPartnerSubCategory() {
		return partnerSubCategoryRepository.getAllPartnerSubCategory();
	}

}
