package com.productcatalogue.service;

import java.text.ParseException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.productcatalogue.entity.ProductEntity;
import com.productcatalogue.model.Product;

public interface ProductService {

	// Add product
	void createProduct(Product product) throws JsonProcessingException, ParseException;

	// Save Active user 
	void saveActiveProduct(ProductEntity productEntity);
	
	void dactivateProductById(ProductEntity product);

	void deactivateProduct(ProductEntity product);

	List<Product> getProducts(Long familyId, String productName, Long productId, Integer limit, Integer offset, String orderBy);

	Long getProductMapCount(Long familyId, Long productOwnerTypeId, Long locationId, Long partnerId); 

	List<Product> getProductMap(Long familyId, Long productOwnerTypeId,
			Long locationId, Long partnerId, String searchText, Integer limit, Integer offset, String orderBy);

	Long getProductCount(Long productId,Long familyId,String productName);


}
