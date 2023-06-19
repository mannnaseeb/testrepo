package com.productcatalogue.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.productcatalogue.entity.PartnertypeEntity;

@Repository
public interface PartnertypeEntityRepository extends JpaRepository<PartnertypeEntity, Integer>{

	@Query(value = "SELECT pt FROM PartnertypeEntity pt")
	List<PartnertypeEntity> getAllPartnertype();

}
