
package com.productcatalogue.rest;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import com.productcatalogue.entity.PartnerEntity;
import com.productcatalogue.model.Partner;
import com.productcatalogue.model.PartnerProductLocation;
import com.productcatalogue.model.PartnerProductLocationRequest;
import com.productcatalogue.service.PartnerService;
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
@Slf4j
@CrossOrigin(origins = "*", allowCredentials = "false")
@RestController
@RequestMapping(value = UrlConstant.Basic.BASE_URL)
public class PartnerAPI {

	@Autowired
	private PartnerService partnerService;

	@Autowired
	private ProductValidation productValidation;

	@Autowired
	private ToolBox toolBox;

	/**
	 * Create partner
	 * 
	 * @param partnerProductLocationRequest
	 * @return
	 * @throws JsonProcessingException
	 * @throws ParseException
	 */
	@PostMapping(path = UrlConstant.URL.CREATE_PARTNER, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> createPartner(@RequestBody PartnerProductLocationRequest partnerProductLocationRequest)
			throws JsonProcessingException, ParseException {

		Map<String, Object> fieldResponse = productValidation.validatePartner(partnerProductLocationRequest);
		if ((int) fieldResponse.get("status") == MessageConstant.Status.BAD_REQUEST) {
			return fieldResponse;
		}

		// Validating id should be in digit
		if (null != partnerProductLocationRequest.getPartner().getPartnerId()) {
			if (!toolBox.validateIdChecker(partnerProductLocationRequest.getPartner().getPartnerId()))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_PARTNER_ID, null, null);
		}

		// Checking name should be in character
		if (null != partnerProductLocationRequest.getPartner().getName()) {
			if (!toolBox.validateCompanyNameChecker(partnerProductLocationRequest.getPartner().getName()))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_PARTNER_NAME, null, null);
		}

		// Add partner
		partnerService.createPartner(partnerProductLocationRequest);
		return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
				MessageConstant.MessageKey.SUCCESS_MESSAGE, partnerProductLocationRequest, null);
	}

	/**
	 * Update Partner
	 * 
	 * @param partnerProductLocationRequest
	 * @return
	 */
	@PostMapping(path = UrlConstant.URL.UPDATE_PARTNER, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> updatePartner(@RequestBody PartnerProductLocationRequest partnerProductLocationRequest) {

		Map<String, Object> fieldResponse = productValidation.validatePartner(partnerProductLocationRequest);
		if ((int) fieldResponse.get("status") == MessageConstant.Status.BAD_REQUEST) {
			return fieldResponse;
		}

		// Validating id should be in digit
		if (null != partnerProductLocationRequest.getPartner().getPartnerId()) {
			if (!toolBox.validateIdChecker(partnerProductLocationRequest.getPartner().getPartnerId()))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_PARTNER_ID, null, null);
		}

		// Checking name should be in character
		if (null != partnerProductLocationRequest.getPartner().getName()) {
			if (!toolBox.validateNameChecker(partnerProductLocationRequest.getPartner().getName()))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_PARTNER_NAME, null, null);
		}

		// Update partner
		partnerService.updatePartner(partnerProductLocationRequest);
		return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
				MessageConstant.MessageKey.UPDATED_MESSAGE, partnerProductLocationRequest, null);

	}

	/**
	 * Get partner form approved location mapping
	 * 
	 * @param familyId
	 * @param locationId
	 * @param searchText
	 * @param productOwnberTypeId
	 * @param limit
	 * @param offset
	 * @param orderBy
	 * @return
	 * @throws JsonProcessingException
	 * @throws ParseException
	 */
	@GetMapping(path = UrlConstant.URL.GET_PARTNER_MAP, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getPartnerMap(@RequestParam(value = Constant.FAMILY_ID, required = false) Long familyId,
			@RequestParam(value = Constant.LOCATION_ID, required = false) Long locationId,
			@RequestParam(value = Constant.PRODUCT_OWNER_TYPE_ID, required = false) Long productOwnerTypeId,
			@RequestParam(value = Constant.SEARCH_TEXT, required = false) String searchText,
			@RequestParam(value = Constant.LIMT, required = false, defaultValue = "20") Integer limit,
			@RequestParam(value = Constant.OFFSET, required = false, defaultValue = "0") Integer offset,
			@RequestParam(value = Constant.ORDER_BY, required = false, defaultValue = "partnerId") String orderBy)
			throws JsonProcessingException, ParseException {

		List<Partner> partners = null;

		// Validating id should be in digits
		if (null != familyId) {
			if (!toolBox.validateIdChecker(familyId))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_FAMILY_ID, null, null);
		} else if (null != locationId) {
			if (!toolBox.validateIdChecker(locationId))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_LOCATION_ID, null, null);
		} else if (null != productOwnerTypeId) {
			if (!toolBox.validateIdChecker(productOwnerTypeId))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_PRODUCT_OWNERTYPE_ID, null, null);
		}

		// Get list of partners
		partners = partnerService.getPartnerMap(familyId, locationId, searchText, productOwnerTypeId, limit, offset,
				orderBy);
		if (!partners.isEmpty()) {
			Long totalCount = partnerService.getPartnerMapCount(familyId, locationId, productOwnerTypeId, searchText);
			return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
					MessageConstant.MessageKey.FETCH_DATA, partners, totalCount);

		}
		return ResponseMessage.responses(MessageConstant.Status.DATA_NOT_FOUND_STATUS,
				MessageConstant.MessageKey.DATA_NOT_FOUND, null, 0L);
	}

	/**
	 * Get the Partner details with the help of limit, offset and orderBy
	 * 
	 * @param partnerId
	 * @param partnerName
	 * @param familyId
	 * @param limit
	 * @param offset
	 * @param orderBy
	 * @return
	 * @throws JsonProcessingException
	 * @throws ParseException
	 */
	@GetMapping(path = UrlConstant.URL.GET_PARTNER, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getPartners(
			@RequestParam(value = Constant.PARTNER_ID, required = false) Long partnerId,
			@RequestParam(value = Constant.PARTNER_NAME, required = false) String partnerName,
			@RequestParam(value = Constant.FAMILY_ID, required = false) Long familyId,
			@RequestParam(value = Constant.LIMT, required = false, defaultValue = "10") Integer limit,
			@RequestParam(value = Constant.OFFSET, required = false, defaultValue = "0") Integer offset,
			@RequestParam(value = Constant.ORDER_BY, required = false, defaultValue = "partnerId") String orderBy)
			throws JsonProcessingException, ParseException {

		List<Partner> partners = null;

		// Validating id should be in digits
		if (null != familyId) {
			if (!toolBox.validateIdChecker(familyId))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_FAMILY_ID, null, null);
		} else if (null != partnerId) {
			if (!toolBox.validateIdChecker(partnerId))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_PARTNER_ID, null, null);
		} else if (null != partnerName) {
			if (!toolBox.validateNameChecker(partnerName))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_PARTNER_NAME, null, null);
		}

		partners = partnerService.getPartners(partnerId, partnerName, limit, offset, orderBy);
		if (!partners.isEmpty()) {
			Long totalCount = partnerService.getPartnerCount(partnerId,partnerName);
			return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
					MessageConstant.MessageKey.FETCH_DATA, partners, totalCount);
		}
		return ResponseMessage.responses(MessageConstant.Status.DATA_NOT_FOUND_STATUS,
				MessageConstant.MessageKey.DATA_NOT_FOUND, null, 0L);

	}

	/**
	 * Data would be return with no.unique location of a Partner and unique product
	 * owned by Partner at all Unique Locations along with Product and Location
	 * mapping
	 * 
	 * @param productId
	 * @return
	 * @throws JsonProcessingException
	 * @throws ParseException
	 */
	@GetMapping(path = UrlConstant.URL.GET_PRODUCT_LOCATION_MAP, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getProductLocationMapping(
			@RequestParam(value = Constant.PARTNER_IDS, required = false) String partnerIds,
			@RequestParam(value = Constant.PARTNER_NAME, required = false) String partnerName,
			@RequestParam(value = Constant.LIMT, required = false, defaultValue = "20") Long limit,
			@RequestParam(value = Constant.OFFSET, required = false, defaultValue = "0") Long offset,
			@RequestParam(value = Constant.ORDER_BY, required = false, defaultValue = "partnerName") String orderBy,
			@RequestParam(value = Constant.SORT_BY, required = false, defaultValue = "partnerName") String sortType)
			throws JsonProcessingException, ParseException {

		// Validate PartnerIds if Null or Empty
		if (null == partnerIds || partnerIds.isEmpty()) {
			return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
					MessageConstant.MessageKey.BLANK_PARTNER_ID, null, null);
		}

		// Checking regex for partner id should be in numeric
		if (null != partnerIds) {
			if (!toolBox.validateIdsChecker(partnerIds)) 
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_PARTNER_ID, null, null);
		}

		List<PartnerProductLocation> partnerProductLocations = null;
		partnerProductLocations = partnerService.getProductLocationMapping(partnerIds, limit, offset, orderBy, sortType);
		if (!partnerProductLocations.isEmpty() && null != partnerProductLocations) {
			Long totalCount = Long.valueOf(partnerService.getProductLocationMappingCount(partnerIds));
			return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
					MessageConstant.MessageKey.FETCH_DATA, partnerProductLocations, totalCount);
		}
		return ResponseMessage.responses(MessageConstant.Status.DATA_NOT_FOUND_STATUS,
				MessageConstant.MessageKey.DATA_NOT_FOUND, null, 0L);
	}

	/**
	 * Deactivate partner
	 * 
	 * @param id
	 * @return
	 * @throws JsonProcessingException
	 * @throws ParseException
	 */
	@PutMapping(path = UrlConstant.URL.DEACTIVATE_PARTNER, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> dactivateProductPartner(@PathVariable(Constant.PARTNER_ID) Long partnerId)
			throws JsonProcessingException, ParseException {

		PartnerEntity partner = null;

		// Calling Validation to validate partner if Blank or Null
		Map<String, Object> fieldResponse = productValidation.validateId(partnerId);
		if ((int) fieldResponse.get("status") == MessageConstant.Status.BAD_REQUEST) {
			return fieldResponse;
		}

		// Checking regex for partner id should be in numeric
		if (null != partnerId) {
			if (!toolBox.validateIdChecker(partnerId)) {
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INVALID_ID, null, null);
			}
		}

		// Fetch partner by id
		// partner = partnerService.getPartnerByPartnerId(partnerId);
		if (null != partner) {
			partner.setIsActive(0);
			partnerService.dactivateProductById(partner);
			return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
					MessageConstant.MessageKey.DEACTIVATE_MESSAGE, null, null);

		}
		return ResponseMessage.responses(MessageConstant.Status.DATA_NOT_FOUND_STATUS,
				MessageConstant.MessageKey.NOT_USER_FOUND, null, null);
	}

	/**
	 * Update partner data
	 * 
	 * @param partnerId
	 * @param partnerEntity
	 * @return
	 */
	@PostMapping(path = UrlConstant.URL.UPDATE_PARTNER_OLD, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> updatePartnerProduct(@PathVariable(Constant.PARTNER_ID) Long partnerId,
			@RequestBody PartnerEntity partnerEntity) throws JsonProcessingException, ParseException {

		Map<String, Object> fieldResponse;
		// Calling Validation to validate product if Blank or Null
		fieldResponse = productValidation.validateId(partnerId);
		if ((int) fieldResponse.get("status") == MessageConstant.Status.BAD_REQUEST) {
			return fieldResponse;
		}

		fieldResponse = productValidation.validatePartnerUpdate(partnerEntity);
		if ((int) fieldResponse.get("status") == MessageConstant.Status.BAD_REQUEST) {
			return fieldResponse;
		}

		// Checking regex for product id should be in numeric
		if (null != partnerId) {
			if (!toolBox.validateIdChecker(partnerId)) {
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INVALID_ID, null, null);
			}
		}

		// Fetch partner by id
		Optional<PartnerEntity> partnerProduct = null;// partnerService.getPartnerProductById(partnerId);
		if (partnerProduct.isPresent()) {

			PartnerEntity partner = partnerProduct.get();
			partner.setName(partnerEntity.getName());
			partner.setCreatedBy(partnerEntity.getCreatedBy());
			partner.setModifiedBy(partnerEntity.getModifiedBy());
			partner.setShortDescription(partnerEntity.getShortDescription());
			partner.setLongDescription(partnerEntity.getLongDescription());

			// Calling service to update partner
			partnerService.updateProductPartner(partner);

			Map<String, Object> partnerData = new HashMap<>(10);
			partnerData.put("name", partner.getName());
			partnerData.put("createdBy", partner.getCreatedBy());
			partnerData.put("modifiedBy", partner.getModifiedBy());
			partnerData.put("short description", partner.getShortDescription());
			partnerData.put("long description", partner.getLongDescription());

			return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
					MessageConstant.MessageKey.UPDATED_MESSAGE, partnerData, null);
		}

		return ResponseMessage.responses(MessageConstant.Status.DATA_NOT_FOUND_STATUS,
				MessageConstant.MessageKey.DATA_NOT_FOUND, null, null);
	}
}