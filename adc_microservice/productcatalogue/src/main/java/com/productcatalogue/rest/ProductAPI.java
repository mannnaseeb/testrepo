package com.productcatalogue.rest;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.productcatalogue.constant.Constant;
import com.productcatalogue.constant.UrlConstant;
import com.productcatalogue.model.Product;
import com.productcatalogue.service.ProductService;
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
@RestController
@CrossOrigin(origins = "*", allowCredentials = "false")
@RequestMapping(value = UrlConstant.Basic.BASE_URL)
public class ProductAPI {

	private static final Logger log = LoggerFactory.getLogger(ProductAPI.class);

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductValidation productValidation;

	@Autowired
	private ToolBox toolBox;

	/**
	 * Create product
	 * 
	 * @param productModel
	 * @return
	 * @throws JsonProcessingException
	 * @throws ParseException
	 */
	@PostMapping(path = UrlConstant.URL.CREATE_PRODUCT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> createProduct(@RequestBody Product product)
			throws JsonProcessingException, ParseException {

		log.info("Create new product", product);

		// Validate product fields
		Map<String, Object> fieldResponse = productValidation.validateCreateProduct(product);
		if ((int) fieldResponse.get("status") == MessageConstant.Status.BAD_REQUEST) {
			return fieldResponse;
		}

		// Validating id should be in digit and name
		if (null != product.getProductId()) {
			if (!toolBox.validateIdChecker(product.getProductId()))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_PRODUCT_ID, null, null);
		} else if (null != product.getName()) {
			if (!toolBox.validateNameChecker(product.getName()))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_PRODUCT_NAME, null, null);
		}

		// Add Product
		productService.createProduct(product);
		return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
				MessageConstant.MessageKey.SUCCESS_MESSAGE, product, null);
	}

	/**
	 * Get all the Product form the data center locations
	 * 
	 * @param productId
	 * @param familyId
	 * @param productName
	 * @param productOwnerTypeId
	 * @param limit
	 * @param offset
	 * @return
	 * @throws JsonProcessingException
	 * @throws ParseException
	 */
	@GetMapping(path = UrlConstant.URL.GET_PRODUCT_MAP, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getProductMap(@RequestParam(value = Constant.FAMILY_ID, required = false) Long familyId,
			@RequestParam(value = Constant.PRODUCT_OWNER_TYPE_ID, required = false) Long productOwnerTypeId,
			@RequestParam(value = Constant.LOCATION_ID, required = false) Long locationId,
			@RequestParam(value = Constant.PARTNER_ID, required = false) Long partnerId,
			@RequestParam(value = Constant.SEARCH_TEXT, required = false) String searchText,
			@RequestParam(value = Constant.LIMT, required = false, defaultValue = "20") Integer limit,
			@RequestParam(value = Constant.OFFSET, required = false, defaultValue = "0") Integer offset,
			@RequestParam(value = Constant.ORDER_BY, required = false, defaultValue = "productId") String orderBy)
			throws JsonProcessingException, ParseException {

		List<Product> products = null;

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
		} else if (null != partnerId) {
			if (!toolBox.validateIdChecker(partnerId))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_PARTNER_ID, null, null);
		}

		products = productService.getProductMap(familyId, productOwnerTypeId, locationId, partnerId, searchText, limit,
				offset, orderBy);

		if (null != products && !products.isEmpty()) {
			Long totalCount = productService.getProductMapCount(familyId, productOwnerTypeId, locationId, partnerId);
			return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
					MessageConstant.MessageKey.FETCH_DATA, products, totalCount);
		}
		return ResponseMessage.responses(MessageConstant.Status.DATA_NOT_FOUND_STATUS,
				MessageConstant.MessageKey.DATA_NOT_FOUND, null, 0L);

	}

	/**
	 * Get product map count
	 * 
	 * @param familyId
	 * @param productOwnerTypeId
	 * @param locationId
	 * @param partnerId
	 * @return
	 */
	@GetMapping(path = UrlConstant.URL.GET_PRODUCT_MAP_COUNT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getProductMapCount(
			@RequestParam(value = Constant.FAMILY_ID, required = false) Long familyId,
			@RequestParam(value = Constant.PRODUCT_OWNER_TYPE_ID, required = false) Long productOwnerTypeId,
			@RequestParam(value = Constant.LOCATION_ID, required = false) Long locationId,
			@RequestParam(value = Constant.PARTNER_ID, required = false) Long partnerId) {

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
		} else if (null != partnerId) {
			if (!toolBox.validateIdChecker(partnerId))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_PARTNER_ID, null, null);
		}

		Long count = productService.getProductMapCount(familyId, productOwnerTypeId, locationId, partnerId);
		if (count != null) {
			return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
					MessageConstant.MessageKey.FETCH_DATA, count, count);
		}
		return ResponseMessage.responses(MessageConstant.Status.DATA_NOT_FOUND_STATUS,
				MessageConstant.MessageKey.DATA_NOT_FOUND, null, 0L);

	}

	/**
	 * Get list of products
	 * 
	 * @param productId
	 * @param familyId
	 * @param productName
	 * @param limit
	 * @param offset
	 * @param orderBy
	 * @return
	 * @throws JsonProcessingException
	 * @throws ParseException
	 */
	@GetMapping(path = UrlConstant.URL.GET_PRODUCT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getProducts(@RequestParam(value = Constant.PRODUCT_ID, required = false) Long productId,
			@RequestParam(value = Constant.FAMILY_ID, required = false) Long familyId,
			@RequestParam(value = Constant.PRODUCT_NAME, required = false) String productName,
			@RequestParam(value = Constant.LIMT, required = false, defaultValue = "10") Integer limit,
			@RequestParam(value = Constant.OFFSET, required = false, defaultValue = "0") Integer offset,
			@RequestParam(value = Constant.ORDER_BY, required = false, defaultValue = "productId") String orderBy)
			throws JsonProcessingException, ParseException {

		List<Product> products = null;

		// Validating id should be in digits
		if (null != familyId) {
			if (!toolBox.validateIdChecker(familyId))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_FAMILY_ID, null, null);
		} else if (null != productId) {
			if (!toolBox.validateIdChecker(productId))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_PRODUCT_ID, null, null);
		} else if (null != productName) {
			if (!toolBox.validateNameChecker(productName))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_PRODUCT_NAME, null, null);
		}
		products = productService.getProducts(familyId, productName, productId, limit, offset, orderBy);

		if (!products.isEmpty()) {
			Long totalCount = productService.getProductCount(productId,familyId,productName);
			return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
					MessageConstant.MessageKey.FETCH_DATA, products, totalCount);
		}
		return ResponseMessage.responses(MessageConstant.Status.DATA_NOT_FOUND_STATUS,
				MessageConstant.MessageKey.DATA_NOT_FOUND, null, 0L);

	}

	/**
	 * Deactivate product
	 * 
	 * @param id
	 * @return
	 * @throws JsonProcessingException
	 * @throws ParseException
	 */
//	@PutMapping(path = UrlConstant.URL.DEACTIVATE_PRODUCT, produces = MediaType.APPLICATION_JSON_VALUE)
//	public Map<String, Object> dactivateProductById(@PathVariable(Constant.PRODUCT_ID) Long productId)
//			throws JsonProcessingException, ParseException {
//
//		ProductEntity productEntity = null;
//		Product product = productService.getProductById(productId);
//		if (null != product) {
//			productEntity.setIsActive(0);
//			productService.deactivateProduct(productEntity);
//
//			return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
//					MessageConstant.MessageKey.DEACTIVATE_MESSAGE, null);
//		}
//
//		return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST, MessageConstant.MessageKey.NOT_USER_FOUND,
//				null);
//
//	}

}
