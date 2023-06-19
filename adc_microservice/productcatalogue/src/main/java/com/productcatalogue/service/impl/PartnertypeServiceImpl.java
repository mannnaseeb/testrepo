package com.productcatalogue.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcatalogue.dao.PartnertypeEntityRepository;
import com.productcatalogue.entity.PartnertypeEntity;
import com.productcatalogue.service.PartnertypeService;

@Service
public class PartnertypeServiceImpl implements PartnertypeService{
	
	@Autowired
	private PartnertypeEntityRepository partnertypeEntityRepository;

	@Override
	public List<PartnertypeEntity> getAllPartnertype() {
		return partnertypeEntityRepository.getAllPartnertype();
	}
}
