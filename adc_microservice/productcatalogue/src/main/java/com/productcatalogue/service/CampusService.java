package com.productcatalogue.service;

import java.util.List;

import com.productcatalogue.entity.CampusEntity;

public interface CampusService {

	// Get the list of campus
	List<CampusEntity> getAllCampus();
	
	// Get total count of campus
	Long getCampusCount();

	// Get count by campusId
	Long getCampusCountById(Long campusId);
	
	// Get campus by id
	CampusEntity getCampusByCampusId(Long campusId);

}
