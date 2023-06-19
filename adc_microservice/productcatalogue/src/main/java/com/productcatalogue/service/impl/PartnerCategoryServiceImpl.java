package com.productcatalogue.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcatalogue.dao.PartnerCategoryRepository;
import com.productcatalogue.entity.PartnerCategoryEntity;
import com.productcatalogue.service.PartnerCategoryService;

@Service
public class PartnerCategoryServiceImpl implements PartnerCategoryService{
	
	@Autowired
	private PartnerCategoryRepository partnerCategoryRepository;

	@Override
	public List<PartnerCategoryEntity> getAllPartnertype() {
		return partnerCategoryRepository.getAllPartnertype();
	}

}
