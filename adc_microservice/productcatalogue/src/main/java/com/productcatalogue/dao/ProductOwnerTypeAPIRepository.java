package com.productcatalogue.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.productcatalogue.entity.ProductOwnerTypeEntity;

public interface ProductOwnerTypeAPIRepository extends JpaRepository<ProductOwnerTypeEntity, Integer>{
	
	@Query(value = "SELECT prod FROM ProductOwnerTypeEntity prod")
	List<ProductOwnerTypeEntity> getAllProductOwnerType(); 
}
