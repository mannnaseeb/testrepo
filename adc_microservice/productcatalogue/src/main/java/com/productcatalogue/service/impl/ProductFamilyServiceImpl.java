package com.productcatalogue.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcatalogue.dao.ProductFamilyDao;
import com.productcatalogue.dao.ProductFamilyRepository;
import com.productcatalogue.entity.ProductFamilyEntity;
import com.productcatalogue.model.ProductFamily;
import com.productcatalogue.service.ProductFamilyService;

@Service
public class ProductFamilyServiceImpl implements ProductFamilyService {

	@Autowired
	private ProductFamilyRepository productFamilyRepository;
	
	@Autowired
	private ProductFamilyDao productFamilyDao;

	@Override
	public ProductFamilyEntity createFamily(ProductFamilyEntity productFamilyEntity) {
		return productFamilyRepository.save(productFamilyEntity);
	}


	@Override
	public void dactivateProductFamilyById(ProductFamilyEntity productFamily) {
		productFamilyRepository.saveAndFlush(productFamily);
	}

	@Override
	public List<ProductFamily> getFamilyMap(Long productOwnerTypeId, Long familyId, String locationIds, Long limit, Long offset, String orderBy) {
		// TODO Auto-generated method stub
		return productFamilyDao.getFamilyMap(productOwnerTypeId, familyId, locationIds, limit, offset, orderBy);
	}

	@Override
	public List<ProductFamily> getFamilies(Long familyId, String familyName, Long limit, Long offset, String orderBy) {
		return productFamilyDao.getFamilies(familyId, familyName, limit, offset, orderBy);
	}


	@Override
	public Long getFamilyMapCount(Long productOwnerTypeId,Long familyId) {
		return productFamilyDao.getFamilyMapCount(productOwnerTypeId,familyId);
	}


	@Override
	public Long getFamilyCount(Long familyId,String familyName) {
		return productFamilyDao.getFamilyCount(familyId,familyName);
	}

	@Override
	public void createProductFamily(ProductFamily productFamily) {
		productFamilyDao.createProductFamily(productFamily);
	}

	


}
