package com.productcatalogue.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productcatalogue.entity.PartnerEntity;

public interface PartnerRepository extends JpaRepository<PartnerEntity, Long> {

	

}
