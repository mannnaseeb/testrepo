package com.productcatalogue.service.impl;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.productcatalogue.dao.DatacenterLocationDao;
import com.productcatalogue.dao.DatacenterLocationRepository;
import com.productcatalogue.entity.DatacenterLocationEntity;
import com.productcatalogue.model.DatacenterLocationModel;
import com.productcatalogue.model.Location;
import com.productcatalogue.model.ProductLocationMap;
import com.productcatalogue.service.DatacenterLocationService;

@Service
public class DatacenterLocationServiceImpl implements DatacenterLocationService {

	@Autowired
	private DatacenterLocationDao locationDao;

	@Autowired
	private DatacenterLocationRepository locationRepository;

	// Add Location
	@Override
	public void createLocation(Location location) throws JsonProcessingException, ParseException {
		locationDao.createProductLocation(location);
	}

	// Update location data center detail
	public void updateLocationDataCenter(DatacenterLocationEntity dcLocationEntity) {
		locationRepository.saveAndFlush(dcLocationEntity);
	}

	// Add product location map
	@Override
	public void addProductLocationMap(ProductLocationMap map) {
		locationDao.addProductLocationMap(map);
	}


	@Override
	public void deactivateDcLocation(DatacenterLocationEntity dcLocation) {
		locationRepository.saveAndFlush(dcLocation);
	}

		@Override
	public List<DatacenterLocationModel> getLocationMap(Long productOwnerTypeId, String locationIds, Integer limit, Integer offset, String orderBy) {
		return locationDao.getLocationMap(productOwnerTypeId, locationIds, limit, offset, orderBy);
	}

	@Override
	public List<DatacenterLocationModel> getLocations(Long locationId, Long regionId, Long countryId, Long metroId,	Long campusId, Integer limit, Integer offset, String orderBy) {
		return locationDao.getLocations(locationId, regionId, countryId, metroId, campusId, limit, offset, orderBy);
	}

	@Override
	public Long getLocationCount(Long locationId, Long regionId, Long countryId, Long metroId, Long campusId) {
		return locationDao.getLocationCount(locationId, regionId, countryId, metroId, campusId);
	}

	@Override
	public Long getLocationMapCount(Long productOwnerTypeId, String locationIds) {
		return locationDao.getLocationMapCount(productOwnerTypeId,locationIds);
	}

	@Override
	public Long getProductPartnerAndLocationCountMap(Long partnerId, Long locationId) {
		return locationDao.getProductPartnerAndLocationCountMap(partnerId, locationId); 
	}

}
