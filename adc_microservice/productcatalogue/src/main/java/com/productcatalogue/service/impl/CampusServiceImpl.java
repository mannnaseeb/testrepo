package com.productcatalogue.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcatalogue.dao.CampusRepository;
import com.productcatalogue.entity.CampusEntity;
import com.productcatalogue.service.CampusService;

@Service
public class CampusServiceImpl implements CampusService{
	
	@Autowired
	private CampusRepository campusRepository;

	// Get the list of campus
	@Override
	public List<CampusEntity> getAllCampus() {
		return campusRepository.getAllCampus();
	}
	
	// Get campus by id
	@Override
	public CampusEntity getCampusByCampusId(Long campusId) {
		return campusRepository.getCampusByCampusId(campusId);
	}

	// Get total count of campus
	@Override
	public Long getCampusCount() {
		return campusRepository.getCampusCount();
	}

	// Get count by campusId
	@Override
	public Long getCampusCountById(Long campusId) {
		return campusRepository.getCampusCountById(campusId);
	}
}
