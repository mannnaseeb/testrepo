package com.productcatalogue.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.productcatalogue.entity.CountryEntity;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Integer> {
	
	// Get the detail of country
	@Query(value = "SELECT cntry.* FROM country cntry where cntry.is_active = 1", nativeQuery = true)
	List<CountryEntity> getAllCountry();

	// Get country by id
	@Query(value = "SELECT cntry.* FROM country cntry where cntry.id =:countryId AND cntry.is_active = 1", nativeQuery = true)
	CountryEntity getCountryByCountryId(Long countryId);

}
