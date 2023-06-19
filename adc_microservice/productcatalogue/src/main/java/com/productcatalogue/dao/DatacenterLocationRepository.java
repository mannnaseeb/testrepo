package com.productcatalogue.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.productcatalogue.entity.DatacenterLocationEntity;

public interface DatacenterLocationRepository extends JpaRepository<DatacenterLocationEntity, Long> {
	
	List<DatacenterLocationEntity> findAll();

	// Get data center location by location id
	@Query(value = "SELECT loc FROM DatacenterLocationEntity loc where locationId =:locationId")
	Optional<DatacenterLocationEntity> getLocationById(String locationId);

	// Fetch the location detail if location is active
	@Query(value = "SELECT loc.* FROM datacenter_location loc where loc.id =:id AND loc.is_active =1", nativeQuery = true)
	DatacenterLocationEntity getLocationById(Long id);
	
}
