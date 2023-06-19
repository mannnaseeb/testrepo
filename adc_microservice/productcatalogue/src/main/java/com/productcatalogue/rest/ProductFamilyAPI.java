package com.productcatalogue.rest;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

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
import com.productcatalogue.entity.ProductFamilyEntity;
import com.productcatalogue.model.ProductFamily;
import com.productcatalogue.service.ProductFamilyService;
import com.productcatalogue.utils.MessageConstant;
import com.productcatalogue.utils.ResponseMessage;
import com.productcatalogue.utils.ToolBox;
import com.productcatalogue.validator.ProductValidation;

/**
 * 
 * @author praveen.gairola
 *
 */
@CrossOrigin(origins = "*", allowCredentials = "false")
@RestController
@RequestMapping(value = UrlConstant.Basic.BASE_URL)
public class ProductFamilyAPI {

	@Autowired
	private ProductFamilyService productFamilyService;

	@Autowired
	private ProductValidation productValidation;

	@Autowired
	private ToolBox toolBox;

	/**
	 * Create family
	 * 
	 * @param productFamily
	 * @return
	 * @throws JsonProcessingException
	 * @throws ParseException
	 */
	@PostMapping(path = UrlConstant.URL.CREATE_PRODUCT_FAMILY, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> createProductFamily(@RequestBody ProductFamily productFamily)
			throws JsonProcessingException, ParseException {

		Map<String, Object> fieldResponse;

		// Calling Validation to validate Product fields to be Null or Empty
		fieldResponse = productValidation.validateCreateProductFamily(productFamily);
		if ((int) fieldResponse.get("status") == MessageConstant.Status.BAD_REQUEST) {
			return fieldResponse;
		}
		
		// Validating id should be in digit and name
		if (null != productFamily.getFamilyId()) {
			if (!toolBox.validateIdChecker(productFamily.getFamilyId()))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_FAMILY_ID, null, null);
		} else if (null != productFamily.getName()) {
			if (!toolBox.validateNameChecker(productFamily.getName()))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_FAMILY_NAME, null, null);
		}

		productFamilyService.createProductFamily(productFamily);
		return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
				MessageConstant.MessageKey.SUCCESS_MESSAGE, productFamily, null);
	}

	/**
	 * Get the family of Product from locations
	 * 
	 * @param id
	 * @param locationIds
	 * @return
	 * @throws JsonProcessingException
	 * @throws ParseException
	 */
	@GetMapping(path = UrlConstant.URL.GET_PRODUCT_FAMILY_MAP, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getFamiliesMap(@RequestParam(value = Constant.FAMILY_ID, required = false) Long familyId,
			@RequestParam(value = Constant.PRODUCT_OWNER_TYPE_ID, required = false) Long productOwnerTypeId,
			@RequestParam(value = Constant.LOCATION_IDS, required = false) String locationIds,
			@RequestParam(value = Constant.LIMT, required = false, defaultValue = "20") Long limit,
			@RequestParam(value = Constant.OFFSET, required = false, defaultValue = "0") Long offset,
			@RequestParam(value = Constant.ORDER_BY, required = false, defaultValue = "familyId") String orderBy)
			throws JsonProcessingException, ParseException {

		List<ProductFamily> productFamilies = null;

		// Validating id should be in digits
		if (null != familyId) {
			if (!toolBox.validateIdChecker(familyId))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_FAMILY_ID, null, null);
		} else if (null != productOwnerTypeId) {
			if (!toolBox.validateIdChecker(productOwnerTypeId))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_PRODUCT_OWNERTYPE_ID, null, null);
		}

		productFamilies = productFamilyService.getFamilyMap(productOwnerTypeId, familyId, locationIds, limit, offset,
				orderBy);

		if (!productFamilies.isEmpty()) {
			Long totalCount = productFamilyService.getFamilyMapCount(productOwnerTypeId,familyId);
			return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
					MessageConstant.MessageKey.FETCH_DATA, productFamilies, totalCount);
		}
		return ResponseMessage.responses(MessageConstant.Status.DATA_NOT_FOUND_STATUS,
				MessageConstant.MessageKey.DATA_NOT_FOUND, null, 0L);
	}

	@GetMapping(path = UrlConstant.URL.GET_PRODUCT_FAMILY, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getFamilies(@RequestParam(value = Constant.FAMILY_ID, required = false) Long familyId,
			@RequestParam(value = Constant.FAMILY_NAME, required = false) String familyName,
			@RequestParam(value = Constant.LIMT, required = false, defaultValue = "20") Long limit,
			@RequestParam(value = Constant.OFFSET, required = false, defaultValue = "0") Long offset,
			@RequestParam(value = Constant.ORDER_BY, required = false, defaultValue = "familyId") String orderBy)
			throws JsonProcessingException, ParseException {

		List<ProductFamily> productFamilies = null;
		if (null != familyId) {
			if (!toolBox.validateIdChecker(familyId))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_FAMILY_ID, null, null);
		} else if (null != familyName) {
			if (!toolBox.validateNameChecker(familyName))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_PRODUCT_NAME, null, null);
		}

		productFamilies = productFamilyService.getFamilies(familyId, familyName, limit, offset, orderBy);

		if (!productFamilies.isEmpty()) {
			Long totalCount = productFamilyService.getFamilyCount(familyId,familyName);
			return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
					MessageConstant.MessageKey.FETCH_DATA, productFamilies, totalCount);
		}
		return ResponseMessage.responses(MessageConstant.Status.DATA_NOT_FOUND_STATUS,
				MessageConstant.MessageKey.DATA_NOT_FOUND, null, 0L);
	}

	/**
	 * Deactivate family
	 * 
	 * @param id
	 * @return
	 * @throws JsonProcessingException
	 * @throws ParseException
	 */
	@PutMapping(path = UrlConstant.URL.DEACTIVATE_PRODUCT_FAMILY, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> dactivateProductFamily(@PathVariable(Constant.FAMILY_ID) Long familyId)
			throws JsonProcessingException, ParseException {

		ProductFamilyEntity productFamilyEntity = new ProductFamilyEntity();
		ProductFamily productFamily = null;// productService.getUniqueProductFamilyByFamilyId(familyId);
		if (null != productFamily) {

			// ProductFamily productFamilyEntity = new productFamily;
			productFamilyEntity.setIsActive(0);
			productFamilyService.dactivateProductFamilyById(productFamilyEntity);

			return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
					MessageConstant.MessageKey.DEACTIVATE_MESSAGE, null, null);

		}
		return ResponseMessage.responses(MessageConstant.Status.DATA_NOT_FOUND_STATUS,
				MessageConstant.MessageKey.NOT_USER_FOUND, null, null);

	}

}
