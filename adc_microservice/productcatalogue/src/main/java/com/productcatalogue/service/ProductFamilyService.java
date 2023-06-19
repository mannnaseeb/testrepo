package com.productcatalogue.service;

import java.util.List;

import com.productcatalogue.entity.ProductFamilyEntity;
import com.productcatalogue.model.ProductFamily;

public interface ProductFamilyService {

	ProductFamilyEntity createFamily(ProductFamilyEntity productFamilyEntity);

	// Add Active family user
	void dactivateProductFamilyById(ProductFamilyEntity productFamily);

	
	public List<ProductFamily> getFamilyMap(Long productOwnerTypeId, Long familyId, String locationIds, Long limit, Long offset, String orderBy);

	List<ProductFamily> getFamilies(Long familyId, String familyName, Long limit, Long offset, String orderBy);

	Long getFamilyMapCount(Long productOwnerTypeId,Long familyId);
	
	Long getFamilyCount(Long familyId,String familyName);

	void createProductFamily(ProductFamily productFamily);
	

}
