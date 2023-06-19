package com.productcatalogue.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.productcatalogue.entity.LocationProductMapping;

@Repository
public interface LocationProductMappingRepository  extends CrudRepository<LocationProductMapping, Long>{
	
}
