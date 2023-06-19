package com.productcatalogue.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcatalogue.dao.PartnerDao;
import com.productcatalogue.dao.PartnerRepository;
import com.productcatalogue.entity.PartnerEntity;
import com.productcatalogue.model.Partner;
import com.productcatalogue.model.PartnerProductLocation;
import com.productcatalogue.model.PartnerProductLocationRequest;
import com.productcatalogue.model.ProductLocationRequest;
import com.productcatalogue.service.PartnerService;
import com.productcatalogue.utils.ProductOwnerTypeEnum;

@Service
public class PartnerServiceImpl implements PartnerService {

	@Autowired
	private PartnerDao partnerDao;

	@Autowired
	private PartnerRepository partnerRepository;


	// Add product partner
	@Override
	public void createPartner(PartnerProductLocationRequest partnerProductLocationRequest) {
		Partner partner = partnerProductLocationRequest.getPartner();
		partnerDao.createPartner(partner);
		List<ProductLocationRequest> productLocationRequestList = partnerProductLocationRequest.getProductLocation();
		for(ProductLocationRequest productLocationRequest : productLocationRequestList) {
			partnerDao.createPartnerMap(productLocationRequest);
		}
		
	}

	// Save active partner to check partner exist or not
	@Override
	public void dactivateProductById(PartnerEntity partner) {
		partnerRepository.saveAndFlush(partner);

	}

	// update partner
	@Override
	public void updateProductPartner(PartnerEntity partner) {
		partnerRepository.saveAndFlush(partner);
	}


	@Override
	public List<PartnerProductLocation> getProductLocationMapping(String partnerIds, Long limit, Long offset, String orderBy, String sortType) {
		
		List<PartnerProductLocation> partnerProductLocationList = new ArrayList<>();
		Partner partner = null;
		
		String[] partnerIdList = partnerIds.split(",");
		for (String partnerId : partnerIdList) {
			List<ProductLocationRequest> productLocationMap = partnerDao.getProductLocationMap(Long.valueOf(partnerId), limit, offset, orderBy, sortType);
			if(null != productLocationMap && productLocationMap.size() > 0) {
				Long locationCount = partnerDao.getLocationMapCount(Long.valueOf(partnerId));
				Long productCount = partnerDao.getProductMapCount(Long.valueOf(partnerId));
				PartnerProductLocation partnerProductLocation = new PartnerProductLocation();
				List<Partner> partnerList = partnerDao.getPartners(Long.valueOf(partnerId), null ,null, null, null);
				if(partnerList != null && partnerList.size() > 0) {
					partner = partnerList.get(0);
					partner.setPartnerId(Long.valueOf(partnerId));
					partnerProductLocation.setProductLocation(productLocationMap);
					Long totalCount = partnerDao.getProductLocationMapTotalCount(Long.valueOf(partnerId));
					partnerProductLocation.setLocationCount(locationCount);
					partnerProductLocation.setProductCount(productCount);
					partnerProductLocation.setTotalcount(totalCount);
					partnerProductLocation.setPartner(partner);
					partnerProductLocationList.add(partnerProductLocation);
				}
			}
		}
		return partnerProductLocationList;
	}

	@Override
	public List<Partner> getPartnerMap(Long familyId, Long locationId, String searchText, Long productOwnerTypeId,
			Integer limit, Integer offset, String orderBy) {
		return partnerDao.getPartnerMap(familyId, locationId, searchText, productOwnerTypeId, limit, offset, orderBy);
	}

	@Override
	public List<Partner> getPartners(Long partnerId, String partnerName, Integer limit, Integer offset, String orderBy) {
		return partnerDao.getPartners(partnerId, partnerName, limit, offset, orderBy);
	}

	@Override
	public Long getPartnerMapCount(Long familyId, Long locationId, Long productOwnberTypeId, String searchText) {
		return partnerDao.getPartnerMapCount(familyId, locationId, productOwnberTypeId, searchText);
	}

	@Override
	public Long getPartnerCount(Long partnerId, String partnerName) {
		return partnerDao.getPartnerCount(partnerId,partnerName);
	}

	@Override
	public Long getProductLocationMappingCount(String partnerIds) {
		return partnerDao.getProductLocationMappingCount(partnerIds);
	}

	@Override
	public void updatePartner(PartnerProductLocationRequest partnerProductLocationRequest) {
		Long partnerId = partnerProductLocationRequest.getPartner().getPartnerId();
		partnerDao.createPartner(partnerProductLocationRequest.getPartner());
		//partnerDao.updatePartner(partnerProductLocationRequest.getPartner());
		List<ProductLocationRequest> productLocationRequestList = partnerProductLocationRequest.getProductLocation();
		for(ProductLocationRequest productLocationRequest: productLocationRequestList) {
			partnerDao.deletePartnerMap(productLocationRequest.getPartnerId(), productLocationRequest.getDataCenterLocationId());
		}for(ProductLocationRequest productLocationRequest: productLocationRequestList) {
			partnerDao.createPartnerMap(productLocationRequest);
		}
	}
}
