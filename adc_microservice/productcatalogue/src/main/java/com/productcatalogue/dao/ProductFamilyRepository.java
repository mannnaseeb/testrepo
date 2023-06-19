package com.productcatalogue.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.productcatalogue.entity.ProductFamilyEntity;

@Repository
public interface ProductFamilyRepository extends JpaRepository<ProductFamilyEntity, Long> {

	@Query(value = "SELECT prod.* FROM product_family prod where prod.id =:id AND prod.is_active =1", nativeQuery = true)
	ProductFamilyEntity getProductFamily(Long id);

	@Query(value = "SELECT prod.* FROM product_family prod where prod.name =:name AND prod.is_active =1", nativeQuery = true)
	ProductFamilyEntity getProductByFamilyName(String name);

}
