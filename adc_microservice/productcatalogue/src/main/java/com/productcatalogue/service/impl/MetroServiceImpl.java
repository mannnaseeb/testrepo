package com.productcatalogue.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcatalogue.dao.MetroRepository;
import com.productcatalogue.entity.MetroEntity;
import com.productcatalogue.service.MetroService;

@Service
public class MetroServiceImpl implements MetroService{

	@Autowired
	private MetroRepository metroRepository;
	
	@Override
	public List<MetroEntity> getAllMetro() {
		
		// Get the metro details
		return metroRepository.getAllMetro();
	}

	// Get metro by id
	@Override
	public MetroEntity getMetroByMetroId(Long metroId) {
		return metroRepository.getMetroByMetroId(metroId);
	}
	
	
}
