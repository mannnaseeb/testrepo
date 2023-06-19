package com.productcatalogue.service;

import java.text.ParseException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.productcatalogue.entity.DatacenterLocationEntity;
import com.productcatalogue.model.DatacenterLocationModel;
import com.productcatalogue.model.Location;
import com.productcatalogue.model.ProductLocationMap;

public interface DatacenterLocationService {

	// Add location
	void createLocation(Location location) throws JsonProcessingException, ParseException;

	// Update location data center detail
	void updateLocationDataCenter(DatacenterLocationEntity dcLocationEntity);

	// Add product location map
	void addProductLocationMap(ProductLocationMap map);


	// Save active
	void deactivateDcLocation(DatacenterLocationEntity dcLocation);

	
	List<DatacenterLocationModel> getLocationMap(Long productOwnerTypeId, String locationIds, Integer limit, Integer offset, String orderBy);

	List<DatacenterLocationModel> getLocations(Long locationId, Long regionId, Long countryId, Long metroId, Long campusId, 
			Integer limit, Integer offset, String orderBy);

	Long getLocationCount(Long locationId, Long regionId, Long countryId, Long metroId, Long campusId);

	Long getLocationMapCount(Long productOwnerTypeId, String locationIds);

	Long getProductPartnerAndLocationCountMap(Long partnerId, Long locationId);

}
