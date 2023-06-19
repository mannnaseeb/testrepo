package com.productcatalogue.service;

import java.util.List;

import com.productcatalogue.entity.CountryEntity;

public interface CountryService {
	
	// Get the detail of country
	List<CountryEntity> getAllCountry();

	// Get country by id 
	CountryEntity getCountryByCountryId(Long countryId);
}
