package com.productcatalogue.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.productcatalogue.entity.CampusEntity;

@Repository
public interface CampusRepository extends JpaRepository<CampusEntity, Integer>{

	// Get the list of campus
	@Query(value = "SELECT camp.* FROM campus camp where camp.is_active = 1", nativeQuery = true)
	List<CampusEntity> getAllCampus();

	// Get campus by id
	@Query(value = "SELECT camp.* FROM campus camp where camp.id =:campusId AND camp.is_active = 1", nativeQuery = true)
	CampusEntity getCampusByCampusId(Long campusId);

	// Get total count of campus
	@Query(value = "SELECT count(camp.id) FROM campus camp where camp.is_active = 1", nativeQuery = true)
	Long getCampusCount();

	// Get count by campusId
	@Query(value = "SELECT count(camp.id) FROM campus camp where camp.id =:campusId and camp.is_active = 1", nativeQuery = true)
	Long getCampusCountById(Long campusId);
	
}
