package com.productcatalogue.rest;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.productcatalogue.constant.Constant;
import com.productcatalogue.constant.UrlConstant;
import com.productcatalogue.entity.DatacenterLocationEntity;
import com.productcatalogue.model.DatacenterLocationModel;
import com.productcatalogue.model.Location;
import com.productcatalogue.model.Product;
import com.productcatalogue.model.ProductLocationMap;
import com.productcatalogue.service.CommonService;
import com.productcatalogue.service.DatacenterLocationService;
import com.productcatalogue.utils.MessageConstant;
import com.productcatalogue.utils.ResponseMessage;
import com.productcatalogue.utils.ToolBox;
import com.productcatalogue.validator.ProductValidation;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author praveen.gairola
 * 
 */
@CrossOrigin(origins = "*", allowCredentials = "false")
@Slf4j
@RestController
@RequestMapping(value = UrlConstant.Basic.BASE_URL)
public class DatacenterLocationAPI {

	private static final Logger logger = LoggerFactory.getLogger(DatacenterLocationAPI.class);

	@Autowired
	private DatacenterLocationService datacenterLocationService;

	@Autowired
	private CommonService commonService;

	@Autowired
	private ProductValidation productValidation;

	@Autowired
	private ToolBox toolBox;

	/**
	 * Create location
	 * 
	 * @param location
	 * @return
	 * @throws JsonProcessingException
	 * @throws ParseException
	 */
	@PostMapping(path = UrlConstant.URL.CREATE_LOCATION, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> createLocation(@RequestBody Location location)
			throws JsonProcessingException, ParseException {

		Map<String, Object> fieldResponse = productValidation.validateCreateProductLocation(location);
		if ((int) fieldResponse.get("status") == MessageConstant.Status.BAD_REQUEST) {
			return fieldResponse;
		}

		// Validating id's
		if (null != location.getRegionId()) {
			if (!toolBox.validateIdChecker(location.getRegionId()))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_REGION_ID, null, null);
		} else if (null != location.getCountryId()) {
			if (!toolBox.validateIdChecker(location.getCountryId()))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_COUNTRY_ID, null, null);
		} else if (null != location.getCampusId()) {
			if (!toolBox.validateIdChecker(location.getCampusId()))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_CAMPUS_ID, null, null);
		} else if (null != location.getMetroId()) {
			if (!toolBox.validateIdChecker(location.getMetroId()))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_METRO_ID, null, null);
		}

		// Add datacenter location
		datacenterLocationService.createLocation(location);
		return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
				MessageConstant.MessageKey.SUCCESS_MESSAGE, location, null);
	}

	/**
	 * Create Product based on location
	 * 
	 * @param productLocationMap
	 * @return
	 * @throws JsonProcessingException
	 * @throws GenericException
	 * @throws ParseException
	 */
	@PostMapping(path = UrlConstant.URL.CREATE_PRODUCT_LOCATION_MAP, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> addProductLocationMap(@RequestBody ProductLocationMap productLocationMap)
			throws JsonProcessingException, ParseException {

		Map<String, Object> fieldResponse = productValidation.validateCreateProductLocationMap(productLocationMap);

		if ((int) fieldResponse.get("status") == MessageConstant.Status.BAD_REQUEST) {
			return fieldResponse;
		}

		datacenterLocationService.addProductLocationMap(productLocationMap);
		return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
				MessageConstant.MessageKey.SUCCESS_MESSAGE, productLocationMap, null);
	}

	/**
	 * Get locations form approved locations
	 * 
	 * @param locationIds
	 * @param productOwnerTypeId
	 * @param limit
	 * @param offset
	 * @param orderBy
	 * @return
	 * @throws JsonProcessingException
	 * @throws ParseException
	 */
	@GetMapping(path = UrlConstant.URL.GET_LOCATION_MAP, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getLocationMap(
			@RequestParam(value = Constant.LOCATION_IDS, required = false) String locationIds,
			@RequestParam(value = Constant.PRODUCT_OWNER_TYPE_ID, required = false) Long productOwnerTypeId,
			@RequestParam(value = Constant.LIMT, required = false, defaultValue = "20") Integer limit,
			@RequestParam(value = Constant.OFFSET, required = false, defaultValue = "0") Integer offset,
			@RequestParam(value = Constant.ORDER_BY, required = false, defaultValue = "locationId") String orderBy)
			throws JsonProcessingException, ParseException {

List<DatacenterLocationModel> dcLocations = null;
		if (null != productOwnerTypeId) {
			if (!toolBox.validateIdChecker(productOwnerTypeId))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_PRODUCT_OWNERTYPE_ID, null, null);
		}

		dcLocations = datacenterLocationService.getLocationMap(productOwnerTypeId, locationIds, limit, offset, orderBy);

		if (!dcLocations.isEmpty()) {
			logger.info("totalcount ::+ totalcount in getLocationMapCount() method");
			Long totalCount = datacenterLocationService.getLocationMapCount(productOwnerTypeId,locationIds);
			logger.info("getLocationMapCount:::::+ AAAAA");
			return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
					MessageConstant.MessageKey.FETCH_DATA, dcLocations, totalCount);
		}
		return ResponseMessage.responses(MessageConstant.Status.DATA_NOT_FOUND_STATUS,
				MessageConstant.MessageKey.DATA_NOT_FOUND, null, 0L);

	}

	/**
	 * Get all the locations form Data-Center
	 * 
	 * @param regionId
	 * @param countryId
	 * @param metroId
	 * @param campusId
	 * @return
	 * @throws JsonProcessingException
	 * @throws ParseException
	 */
	@GetMapping(path = UrlConstant.URL.GET_LOCATION, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getAllUniqueLocation(
			@RequestParam(value = Constant.LOCATION_ID, required = false) Long locationId,
			@RequestParam(value = Constant.REGION_ID, required = false) Long regionId,
			@RequestParam(value = Constant.COUNTRY_ID, required = false) Long countryId,
			@RequestParam(value = Constant.METRO_ID, required = false) Long metroId,
			@RequestParam(value = Constant.CAMPUS_ID, required = false) Long campusId,
			@RequestParam(value = Constant.LIMT, required = false, defaultValue = "20") Integer limit,
			@RequestParam(value = Constant.OFFSET, required = false, defaultValue = "0") Integer offset,
			@RequestParam(value = Constant.ORDER_BY, required = false, defaultValue = "locationId") String orderBy)
			throws JsonProcessingException, ParseException {

		List<DatacenterLocationModel> dcLocations = null;

		// Validating id should be in digits
		if (null != locationId) {
			if (!toolBox.validateIdChecker(locationId))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_FAMILY_ID, null, null);
		} else if (null != regionId) {
			if (!toolBox.validateIdChecker(regionId))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_REGION_ID, null, null);
		} else if (null != countryId) {
			if (!toolBox.validateIdChecker(countryId))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_COUNTRY_ID, null, null);
		} else if (null != campusId) {
			if (!toolBox.validateIdChecker(campusId))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_CAMPUS_ID, null, null);
		} else if (null != metroId) {
			if (!toolBox.validateIdChecker(metroId))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_METRO_ID, null, null);
		}

		dcLocations = datacenterLocationService.getLocations(locationId, regionId, countryId, metroId, campusId, limit,
				offset, orderBy);

		if (!dcLocations.isEmpty()) {
			Long totalCount = datacenterLocationService.getLocationCount(locationId, regionId, countryId, metroId,
					campusId);
			return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
					MessageConstant.MessageKey.FETCH_DATA, dcLocations, totalCount);
		}
		return ResponseMessage.responses(MessageConstant.Status.DATA_NOT_FOUND_STATUS,
				MessageConstant.MessageKey.DATA_NOT_FOUND, null, 0L);
	}

	/**
	 * Get All Product on all locations
	 * 
	 * @param id
	 * @return
	 * @throws JsonProcessingException
	 * @throws ParseException
	 */
	@GetMapping(path = UrlConstant.URL.GET_PARTNER_PRODUCT_LOCATION, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getAllPartnerAndProductByLocationId(@PathVariable(Constant.LOCATION_ID) Long locationId)
			throws JsonProcessingException, ParseException {

		List<DatacenterLocationModel> datacenterLocationModels = null;

		Map<String, Object> fieldResponse = productValidation.validateLocationId(locationId);
		if ((int) fieldResponse.get("status") == MessageConstant.Status.BAD_REQUEST) {
			return fieldResponse;
		}

		// Validating id should be in digits
		if (null != locationId) {
			if (!toolBox.validateIdChecker(locationId))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_LOCATION_ID, null, null);
		}

		datacenterLocationModels = commonService.getAllPartnerAndProductByLocationId(locationId);

		if (!datacenterLocationModels.isEmpty()) {
			Long totalCount = Long.valueOf(datacenterLocationModels.size());
			return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
					MessageConstant.MessageKey.FETCH_DATA, datacenterLocationModels, totalCount);
		}
		return ResponseMessage.responses(MessageConstant.Status.DATA_NOT_FOUND_STATUS,
				MessageConstant.MessageKey.DATA_NOT_FOUND, null, 0L);
	}

	/**
	 * Get All Product for the Partner on selected location
	 * 
	 * @param map
	 * @return
	 * @throws JsonProcessingException
	 * @throws ParseException
	 */
	@GetMapping(path = UrlConstant.URL.GET_LOCATION_BY_SELCTED_PRODUCT_PARTNER, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getProductByPartnersAndLocationId(@PathVariable(Constant.PARTNER_ID) Long partnerId,
			@PathVariable(Constant.LOCATION_ID) Long locationId) throws JsonProcessingException, ParseException {

		Map<String, Object> fieldResponse = productValidation.validateParnerAndLocationId(partnerId, partnerId);
		if ((int) fieldResponse.get("status") == MessageConstant.Status.BAD_REQUEST) {
			return fieldResponse;
		}

		if (null != partnerId) {
			if (!toolBox.validateIdChecker(partnerId)) {
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_PARTNER_ID, null, null);
			} else if (null != locationId) {
				if (!toolBox.validateIdChecker(locationId))
					return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
							MessageConstant.MessageKey.INAVLID_LOCATION_ID, null, null);
			}
		}

		// Fetch All Product for the Partner on selected location by partner and
		// location id
		List<Product> listProductPartner = commonService.getProductByPartnerAndLocationId(partnerId, locationId);
		if (!listProductPartner.isEmpty()) {
			//Long totalCount = Long.valueOf(listProductPartner.size());
			Long totalCount = datacenterLocationService.getProductPartnerAndLocationCountMap(partnerId, locationId);
			return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS, MessageConstant.MessageKey.FETCH_DATA,
					listProductPartner, totalCount);
		}
		return ResponseMessage.responses(MessageConstant.Status.DATA_NOT_FOUND_STATUS,
				MessageConstant.MessageKey.DATA_NOT_FOUND, null, null);
	}

	/**
	 * Deactivate data center location
	 * 
	 * @param id
	 * @return
	 * @throws JsonProcessingException
	 * @throws ParseException
	 */
	@PutMapping(path = UrlConstant.URL.DEACTIVATE_LOCATION, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> deactivateLocation(@PathVariable(Constant.LOCATION_ID) Long locationId)
			throws JsonProcessingException, ParseException {

		DatacenterLocationEntity dcLocation = null;
		Map<String, Object> fieldResponse = productValidation.validateId(locationId);
		if ((int) fieldResponse.get("status") == MessageConstant.Status.BAD_REQUEST) {
			return fieldResponse;
		}

		if (null != locationId) {
			if (!toolBox.validateIdChecker(locationId)) {
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INVALID_ID, null, null);
			}
		}

//		dcLocation = datacenterLocationService.getLocationById(locationId);
		if (null != dcLocation) {
			dcLocation.setIsActive(0);
			datacenterLocationService.deactivateDcLocation(dcLocation);
			return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
					MessageConstant.MessageKey.DEACTIVATE_MESSAGE, null, null);

		}
		return ResponseMessage.responses(MessageConstant.Status.DATA_NOT_FOUND_STATUS,
				MessageConstant.MessageKey.NOT_USER_FOUND, null, null);
	}

	/**
	 * Update location
	 * 
	 * @param id
	 * @param datacenterLocationEntity
	 * @return
	 * @throws JsonProcessingException
	 * @throws ParseException
	 */
	@PutMapping(path = UrlConstant.URL.UPDATE_LOCATION, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> updateLocation(@PathVariable(Constant.LOCATION_ID) Long locationId,
			@RequestBody DatacenterLocationEntity datacenterLocationEntity)
			throws JsonProcessingException, ParseException {

		DatacenterLocationEntity dcLocation = null;
		Map<String, Object> fieldResponse = productValidation.validateId(locationId);
		if ((int) fieldResponse.get("status") == MessageConstant.Status.BAD_REQUEST) {
			return fieldResponse;
		}

		if (null != locationId) {
			if (!toolBox.validateIdChecker(locationId)) {
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INVALID_ID, null, null);
			}
		}

		// dcLocation = datacenterLocationService.getAllUniqueLocation(locationId, null,
		// null, null, null);
		if (null != dcLocation) {
			DatacenterLocationEntity dcLocationEntity = dcLocation;

			dcLocationEntity.setModifiedBy(datacenterLocationEntity.getModifiedBy());
			dcLocationEntity.setCreatedBy(datacenterLocationEntity.getCreatedBy());

			datacenterLocationService.updateLocationDataCenter(dcLocationEntity);

			Map<String, Object> locData = new HashMap<>(10);
			locData.put("createdBy", datacenterLocationEntity.getCreatedBy());
			locData.put("modifiedBy", datacenterLocationEntity.getModifiedBy());

			return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
					MessageConstant.MessageKey.UPDATED_MESSAGE, locData, null);
		}
		return ResponseMessage.responses(MessageConstant.Status.DATA_NOT_FOUND_STATUS,
				MessageConstant.MessageKey.DATA_NOT_FOUND, null, null);
	}

}
