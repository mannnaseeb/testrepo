package com.productcatalogue.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.productcatalogue.model.Product;
import com.productcatalogue.model.ProductFamily;

@Mapper
public interface ProductDao {

	// Calling mapping to inject insert data of product 
	public void createProduct(Product product);
	
	// Calling mapping to inject insert data of product family
	public void createProductFamily(ProductFamily productFamily);
	
	/**
	 * 
	 * @param productOwnerTypeId
	 * @return
	 */
	public Long getProductMapCount(@Param("familyId") Long familyId, @Param("productOwnerTypeId") Long productOwnerTypeId,
			@Param("locationId") Long locationId, @Param("partnerId") Long partnerId);

	/**
	 * 
	 * @param familyId
	 * @param productOwnerTypeId
	 * @param locationId
	 * @param partnerId
	 * @param searchText
	 * @param limit
	 * @param offset
	 * @param orderBy
	 * @return
	 */
	public List<Product> getProductMap(@Param("familyId") Long familyId, @Param("productOwnerTypeId") Long productOwnerTypeId,
			@Param("locationId") Long locationId, @Param("partnerId") Long partnerId, @Param("searchText") String searchText, @Param("limit") Integer limit,
			@Param("offset") Integer offset, @Param("orderBy") String orderBy);

	/**
	 * 
	 * @param familyId
	 * @param productName
	 * @param productId
	 * @param limit
	 * @param offset
	 * @param orderBy
	 * @return
	 */
	public List<Product> getProducts(@Param("familyId") Long familyId, @Param("productName") String productName, @Param("productId") Long productId, 
			@Param("limit") Integer limit, @Param("offset") Integer offset, @Param("orderBy") String orderBy);
	
	/**
	 * 
	 * @return
	 */
	public Long getProductCount(@Param("productId") Long productId,@Param("familyId") Long familyId, @Param("productName") String productName);
	
}
