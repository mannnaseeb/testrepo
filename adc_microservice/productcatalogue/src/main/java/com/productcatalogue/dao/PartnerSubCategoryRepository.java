package com.productcatalogue.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.productcatalogue.entity.PartnerSubcategoryEntity;

@Repository
public interface PartnerSubCategoryRepository extends JpaRepository<PartnerSubcategoryEntity, Integer>{
	
	// Get the list of partner sub-categories
	@Query(value = "SELECT prtnr FROM PartnerSubcategoryEntity prtnr")
	List<PartnerSubcategoryEntity> getAllPartnerSubCategory();

}
