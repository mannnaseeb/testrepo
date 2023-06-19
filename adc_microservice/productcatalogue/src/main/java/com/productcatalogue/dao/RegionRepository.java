package com.productcatalogue.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.productcatalogue.entity.RegionEntity;

@Repository
public interface RegionRepository extends JpaRepository<RegionEntity, Integer>{
	
	// Get list of region
	@Query(value = "SELECT reg.* FROM region reg where reg.is_active = 1", nativeQuery = true)
	List<RegionEntity> getAllRegion();

	// Get regions by region id
	@Query(value = "SELECT reg.* FROM region reg where reg.id =:regionId AND reg.is_active = 1", nativeQuery = true)
	RegionEntity getRegionByRegionId(Long regionId);

}
