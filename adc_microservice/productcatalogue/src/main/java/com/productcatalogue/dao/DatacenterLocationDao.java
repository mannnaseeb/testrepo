package com.productcatalogue.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.productcatalogue.model.DatacenterLocationModel;
import com.productcatalogue.model.Location;
import com.productcatalogue.model.ProductLocationMap;

@Mapper
public interface DatacenterLocationDao {

	// fetch the location along with other tables
	/**
	 * 
	 * @return
	 */
	List<DatacenterLocationModel> getDatacenterLocation(Long locationId);

	// Add product location map
	/**
	 * 
	 * @param map
	 */
	void addProductLocationMap(ProductLocationMap map);

	// Add location
	/**
	 * 
	 * @param location
	 */
	void createProductLocation(Location location);
	/**
	 * 
	 * @param id
	 */
	void deactivateDcLocation(Long id);
	/**
	 * 
	 * @param productOwnerTypeId
	 * @param locationIds
	 * @param limit
	 * @param offset
	 * @param orderBy
	 * @return
	 */
	List<DatacenterLocationModel> getLocationMap(@Param("productOwnerTypeId") Long productOwnerTypeId, @Param("locationIds") String locationIds, 
			@Param("limit") Integer limit, @Param("offset") Integer offset, @Param("orderBy") String orderBy);
	/**
	 * 
	 * @param locationId
	 * @param regionId
	 * @param countryId
	 * @param metroId
	 * @param campusId
	 * @param limit
	 * @param offset
	 * @param orderBy
	 * @return
	 */
	List<DatacenterLocationModel> getLocations(@Param("locationId") Long locationId, @Param("regionId") Long regionId, @Param("countryId") Long countryId, 
			@Param("metroId") Long metroId, @Param("campusId") Long campusId, @Param("limit") Integer limit, @Param("offset") Integer offset, 
			@Param("orderBy") String orderBy);
	/**
	 * 
	 * @return
	 */
	public Long getLocationCount(@Param("locationId") Long locationId, @Param("regionId") Long regionId, @Param("countryId") Long countryId, 
			@Param("metroId") Long metroId, @Param("campusId") Long campusId);
	/**
	 * 
	 * @param productOwnerTypeId
	 * @return
	 */
	public Long getLocationMapCount(@Param("productOwnerTypeId") Long productOwnerTypeId, @Param("locationIds") String locationIds);

	Long getProductPartnerAndLocationCountMap(Long partnerId, Long locationId);

}
