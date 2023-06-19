package com.productcatalogue.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.productcatalogue.entity.MetroEntity;

@Repository
public interface MetroRepository extends JpaRepository<MetroEntity, Integer>{

	// Get the metro details
	@Query(value = "SELECT mtro.* FROM metro mtro where mtro.is_active = 1", nativeQuery = true)
	List<MetroEntity> getAllMetro();

	// Get metro by id
	@Query(value = "SELECT mtro.* FROM metro mtro where mtro.id =:metroId AND mtro.is_active = 1", nativeQuery = true)
	MetroEntity getMetroByMetroId(Long metroId);

}
