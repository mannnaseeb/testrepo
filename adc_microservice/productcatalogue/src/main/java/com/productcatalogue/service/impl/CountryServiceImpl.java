package com.productcatalogue.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcatalogue.dao.CountryRepository;
import com.productcatalogue.entity.CountryEntity;
import com.productcatalogue.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Override
	public List<CountryEntity> getAllCountry() {

		// Get the detail of country
		return countryRepository.getAllCountry();
	}

	// Get country by id
	@Override
	public CountryEntity getCountryByCountryId(Long countryId) {
		return countryRepository.getCountryByCountryId(countryId);
	}

}
