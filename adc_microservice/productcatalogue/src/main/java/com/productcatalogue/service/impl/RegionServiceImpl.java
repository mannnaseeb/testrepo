package com.productcatalogue.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcatalogue.dao.RegionRepository;
import com.productcatalogue.entity.RegionEntity;
import com.productcatalogue.service.RegionService;

@Service
public class RegionServiceImpl implements RegionService {
	
	@Autowired
	private RegionRepository regionRepository;

	// Get list of region
	@Override
	public List<RegionEntity> getAllRegion() {
		return regionRepository.getAllRegion();
	}

	// Get regions by region id
	@Override
	public RegionEntity getRegionByRegionId(Long regionId) {
		return regionRepository.getRegionByRegionId(regionId);
	}
}
