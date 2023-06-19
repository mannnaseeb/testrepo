package com.productcatalogue.service;

import java.util.List;

import com.productcatalogue.entity.PartnerEntity;
import com.productcatalogue.model.Partner;
import com.productcatalogue.model.PartnerProductLocation;
import com.productcatalogue.model.PartnerProductLocationRequest;

public interface PartnerService {

	// Add product partner
	void createPartner(PartnerProductLocationRequest partnerProductLocationRequest) ;

	// Save active partner to check partner exist or not?
	void dactivateProductById(PartnerEntity partner);

	// update partner
	void updateProductPartner(PartnerEntity partner);

	
	List<PartnerProductLocation> getProductLocationMapping(String partnerIds, Long limit, Long offset, String orderBy, String sortType);
	
	List<Partner> getPartnerMap(Long familyId, Long locationId, String searchText, Long productOwnberTypeId,
			Integer limit, Integer offset, String orderBy);

	List<Partner> getPartners(Long partnerId, String partnerName, Integer limit, Integer offset, String orderBy);

	Long getPartnerMapCount(Long familyId, Long locationId, Long productOwnberTypeId, String searchText);

	Long getPartnerCount(Long partnerId, String partnerName);

	Long getProductLocationMappingCount(String partnerIds);

	void updatePartner(PartnerProductLocationRequest partnerProductLocationRequest);

}
