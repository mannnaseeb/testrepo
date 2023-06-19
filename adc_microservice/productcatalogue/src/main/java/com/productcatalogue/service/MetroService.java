package com.productcatalogue.service;

import java.util.List;

import com.productcatalogue.entity.MetroEntity;

public interface MetroService {
	
	// Get the metro details
	List<MetroEntity> getAllMetro();

	// Get metro by id
	MetroEntity getMetroByMetroId(Long metroId);

}
