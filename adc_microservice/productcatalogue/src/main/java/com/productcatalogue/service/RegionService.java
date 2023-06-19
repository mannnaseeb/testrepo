package com.productcatalogue.service;

import java.util.List;

import com.productcatalogue.entity.RegionEntity;

public interface RegionService {

	// Get list of region
	List<RegionEntity> getAllRegion();

	// Get regions by region id
	RegionEntity getRegionByRegionId(Long regionId);

}
