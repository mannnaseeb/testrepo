package com.productcatalogue.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productcatalogue.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	
	// Get all product
//	@Query(value = "SELECT prod.* FROM product prod  where prod.is_active = 1 order by Caption asc limit :limit offset :offset", nativeQuery = true)
//	List<Product> getAllProduct(Integer limit, Integer offset);
//
//	@Query(value = "SELECT prod.* FROM product prod where prod.name =:name AND prod.is_active = 1", nativeQuery = true)
//	ProductEntity findByName(@Param("name") String name);
//	
//	@Query(value = "SELECT prod.* FROM product prod where prod.product_family_id =:productFamilyId AND prod.is_active = 1", nativeQuery = true)
//	List<ProductEntity> getProductByProductFamilyId(Long productFamilyId);
//
//	// Get product Active user by id
//	@Query(value = "SELECT prod.* FROM product prod where prod.id =:productId AND prod.is_active =1", nativeQuery = true)
//	ProductEntity findByProductId(Long productId);

}
