package com.productcatalogue.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.productcatalogue.model.ProductFamily;

@Mapper
public interface ProductFamilyDao {
	/**
	 * 
	 * @param familyId
	 * @param locationIds
	 * @param limit
	 * @param offset
	 * @param orderBy
	 * @return
	 */
	List<ProductFamily> getFamilyMap(@Param("productOwnerTypeId") Long productOwnerTypeId, @Param("familyId") Long familyId, 
			@Param("locationIds") String locationIds, @Param("limit") Long limit, @Param("offset") Long offset, @Param("orderBy") String orderBy);
	/**
	 * 
	 * @param productOwnerTypeId
	 * @return
	 */
	Long getFamilyMapCount(@Param("productOwnerTypeId") Long productOwnerTypeId,@Param("familyId") Long familyId);
	/**
	 * 
	 * @return
	 */
	Long getFamilyCount(@Param("familyId") Long familyId, @Param("familyName") String familyName);
	/**
	 * 
	 * @param familyId
	 * @param familyName
	 * @param limit
	 * @param offset
	 * @param orderBy
	 * @return
	 */
	List<ProductFamily> getFamilies(@Param("familyId") Long familyId, @Param("familyName") String familyName, @Param("limit") Long limit, 
			@Param("offset") Long offset, @Param("orderBy") String orderBy);
	
	void createProductFamily(ProductFamily productFamily);


}
