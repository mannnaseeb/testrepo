package com.productcatalogue.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.productcatalogue.model.Partner;
import com.productcatalogue.model.ProductLocationRequest;

@Mapper
public interface PartnerDao {

	/**
	 * Add product partner
	 * @param partner
	 */
	public void createPartner(Partner partner);
	

	/**
	 * 
	 * @param locationId
	 * @param productOwnerTypeId
	 * @return
	 */
	public Long getLocationMapCount(@Param("partnerId") Long partnerId);
	
	/**
	 * 
	 * @param productId
	 * @param productOwnerTypeId
	 * @return
	 */
	public Long getProductMapCount(@Param("partnerId") Long partnerId);
	
	/**
	 * Get all partner form approved location mapping
	 * Get partner can by familyId, locationId and productOwnerTypeId
	 * Display 50 partner details on each page along of offset
	 * Display partner using orderBy
	 * 
	 * @param familyId
	 * @param locationId
	 * @param searchText
	 * @param productOwnberTypeId
	 * @param limit
	 * @param offset
	 * @param orderBy
	 * @return
	 */
	public List<Partner> getPartnerMap(@Param("familyId") Long familyId, @Param("locationId") Long locationId, 
			@Param("searchText") String searchText, @Param("productOwnerTypeId") Long productOwnerTypeId, @Param("limit") Integer limit, 
			@Param("offset") Integer offset, @Param("orderBy") String orderBy);
	
	/**
	 * 
	 * @param partnerId
	 * @param partnerName
	 * @param limit
	 * @param offset
	 * @param orderBy
	 * @return
	 */
	public List<Partner>  getPartners(@Param("partnerId") Long partnerId, @Param("partnerName") String partnerName, @Param("limit") Integer limit, 
			@Param("offset") Integer offset, @Param("orderBy") String orderBy);
	
	/**
	 * 
	 * @param productOwnerTypeId
	 * @return
	 */
	public Long getPartnerMapCount(@Param("familyId") Long familyId, @Param("locationId") Long locationId, @Param("productOwnerTypeId") Long productOwnerTypeId, 
			@Param("searchText") String searchText); 

	/**
	 * 
	 * @return
	 */
	public Long getPartnerCount(@Param("partnerId") Long partnerId, @Param("partnerName") String partnerName);
	
	public Long getProductLocationMappingCount(@Param("partnerId") String partnerId);
	/**
	 * 
	 * @param partner
	 * @param productLocationRequest
	 */
	public void createPartnerMap(ProductLocationRequest productLocationRequest);


	public List<ProductLocationRequest> getProductLocationMap(@Param("partnerId") Long partnerId, @Param("limit") Long limit, 
			@Param("offset") Long offset, @Param("orderBy") String orderBy, String sortType);
	
	public void deletePartnerMap(@Param("partnerId") Long partnerId, @Param("locationId") Long locationId);


	public void updatePartner(@Param("partner") Partner partner);


	public Long getProductLocationMapTotalCount(@Param("partnerId") Long partnerId);

}
