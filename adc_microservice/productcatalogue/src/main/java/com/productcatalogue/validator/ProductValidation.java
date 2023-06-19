package com.productcatalogue.validator;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.productcatalogue.entity.PartnerEntity;
import com.productcatalogue.model.Location;
import com.productcatalogue.model.PartnerProductLocationRequest;
import com.productcatalogue.model.PartnerProductModel;
import com.productcatalogue.model.Product;
import com.productcatalogue.model.ProductFamily;
import com.productcatalogue.model.ProductLocationMap;
import com.productcatalogue.utils.MessageConstant;
import com.productcatalogue.utils.ResponseMessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ProductValidation {

	private static final Logger logger = LoggerFactory.getLogger(ProductValidation.class);

	Map<String, Object> finalResponse;

	// Validating Product fields if blank the return bad message with error code
	public Map<String, Object> validateCreateProduct(Product product) {
		if (product.getName() == null || product.getName().isEmpty()) {
			return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
					MessageConstant.MessageKey.BLANK_PRODUCT_NAME, null, null);
		} else if (product.getProductId() == null) {
			return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
					MessageConstant.MessageKey.BLANK_PRODUCT_ID, null, null);
		}

		finalResponse = new HashMap<>();
		finalResponse.put("validated", true);
		return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
				MessageConstant.MessageKey.SUCCESS_MESSAGE, finalResponse, null);
	}

	// Validate Partner fields if blank the return bad message with error code
	public Map<String, Object> validatePartner(PartnerProductLocationRequest partnerProductLocationRequest) {
		if (partnerProductLocationRequest.getPartner().getPartnerId() == null) {
			return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
					MessageConstant.MessageKey.BLANK_PARTNER_ID, null, null);
		} else if (partnerProductLocationRequest.getPartner().getName() == null
				|| partnerProductLocationRequest.getPartner().getName().isEmpty()) {
			return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
					MessageConstant.MessageKey.BLANK_PARTNER_NAME, null, null);
		}
		finalResponse = new HashMap<>();
		finalResponse.put("validated", true);
		return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
				MessageConstant.MessageKey.SUCCESS_MESSAGE, finalResponse, null);

	}

	// Validating id filed if blank/null that return error message with status code
	public Map<String, Object> validateLocationId(Long id) {
		if (id == null || id.equals("")) {
			return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
					MessageConstant.MessageKey.BLANK_FIELD_LOCATION_ID, null, null);
		}

		finalResponse = new HashMap<>();
		finalResponse.put("validated", true);
		return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
				MessageConstant.MessageKey.SUCCESS_MESSAGE, finalResponse, null);
	}

	// Validating product name filed if blank the return bad message with error code
	public Map<String, Object> validateProductName(String productName) {
		if (productName != null || productName.equals("")) {
			return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
					MessageConstant.MessageKey.BLANK_PRODUCT_NAME, null, null);
		}

		finalResponse = new HashMap<>();
		finalResponse.put("validated", true);
		return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
				MessageConstant.MessageKey.SUCCESS_MESSAGE, finalResponse, null);
	}

	// Validate product family filed if blank the return bad message with error code
	public Map<String, Object> validateCreateProductFamily(ProductFamily productFamily) {
		if (productFamily.getName() == null || productFamily.getName().isEmpty()) {
			return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST, MessageConstant.MessageKey.BLANK_FAMILY_NAME,
					null, null);
		} else if (productFamily.getFamilyId() == null || productFamily.getFamilyId().equals("")) {
			return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
					MessageConstant.MessageKey.BLANK_FAMILY_ID, null, null);
		} 

		finalResponse = new HashMap<>();
		finalResponse.put("validated", true);
		return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
				MessageConstant.MessageKey.SUCCESS_MESSAGE, finalResponse, null);
	}

	// Validate location filed if blank the return bad message with error code
	public Map<String, Object> validateCreateProductLocation(Location location) {
		if (location.getRegionId() == null || location.getRegionId().equals("")) {
			return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
					MessageConstant.MessageKey.BLANK_FIELD_REGION_ID, null, null);
		} else if (location.getCountryId() == null || location.getCountryId().equals("")) {
			return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
					MessageConstant.MessageKey.BLANK_FIELD_COUNTRY_ID, null, null);
		} else if (location.getMetroId() == null || location.getMetroId().equals("")) {
			return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
					MessageConstant.MessageKey.BLANK_FIELD_METRO_ID, null, null);
		} else if (location.getCampusId() == null || location.getCampusId().equals("")) {
			return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
					MessageConstant.MessageKey.BLANK_FIELD_CAMPUS_ID, null, null);
		}

		finalResponse = new HashMap<>();
		finalResponse.put("validated", true);
		return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
				MessageConstant.MessageKey.SUCCESS_MESSAGE, finalResponse, null);
	}

	// Validate product-location-map fields if blank the return bad message with
	// error code
	public Map<String, Object> validateCreateProductLocationMap(ProductLocationMap productLocationMap) {

		if (productLocationMap.getLocation() == null) {
			return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
					MessageConstant.MessageKey.BLANK_FIELD_ID, null, null);
		} else if (productLocationMap.getProduct() == null) {
			return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
					MessageConstant.MessageKey.BLANK_FIELD_ID, null, null);
		} else if (productLocationMap.getFamily() == null) {
			return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
					MessageConstant.MessageKey.BLANK_FIELD_ID, null, null);
		}

		finalResponse = new HashMap<>();
		finalResponse.put("validated", true);
		return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
				MessageConstant.MessageKey.SUCCESS_MESSAGE, finalResponse, null);
	}

	// Validate partner and location filed if blank the return bad message with
	// error code
	public Map<String, Object> validateParnerAndLocationId(Long partnerId, Long locationId) {
		if (null == partnerId || partnerId.equals("")) {
			return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
					MessageConstant.MessageKey.BLANK_PARTNER_ID, null, null);
		} else if (null == locationId || locationId.equals("")) {
			return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
					MessageConstant.MessageKey.BLANK_FIELD_LOCATION_ID, null, null);
		}

		finalResponse = new HashMap<>();
		finalResponse.put("validated", true);
		return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
				MessageConstant.MessageKey.SUCCESS_MESSAGE, finalResponse, null);
	}

	public Map<String, Object> validateId(Long locationId) {
		if (null == locationId || locationId.equals("")) {
			return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
					MessageConstant.MessageKey.BLANK_FIELD_LOCATION_ID, null, null);
		}

		finalResponse = new HashMap<>();
		finalResponse.put("validated", true);
		return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
				MessageConstant.MessageKey.SUCCESS_MESSAGE, finalResponse, null);
	}

	// Validate product partner filed if blank the return bad message with error
	// code
	public Map<String, Object> validateProductPartner(PartnerProductModel partnerProduct) {
		if (partnerProduct.getName() == null || partnerProduct.getName().isEmpty()) {
			return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST, MessageConstant.MessageKey.BLANK_NAME,
					null, null);
		} else if (partnerProduct.getCreatedBy() == null || partnerProduct.getCreatedBy().isEmpty()) {
			return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
					MessageConstant.MessageKey.BLANK_CREATED_BY, null, null);
		} else if (partnerProduct.getModifiedBy() == null || partnerProduct.getModifiedBy().isEmpty()) {
			return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
					MessageConstant.MessageKey.BLANK_MODIFIED_BY, null, null);
		}

		finalResponse = new HashMap<>();
		finalResponse.put("validated", true);
		return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
				MessageConstant.MessageKey.SUCCESS_MESSAGE, finalResponse, null);
	}

	public Map<String, Object> validatePartnerUpdate(PartnerEntity partner) {
		if (partner.getName() == null || partner.getName().isEmpty()) {
			return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST, MessageConstant.MessageKey.BLANK_NAME,
					null, null);
		} else if (partner.getCreatedBy() == null || partner.getCreatedBy().isEmpty()) {
			return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
					MessageConstant.MessageKey.BLANK_CREATED_BY, null, null);
		} else if (partner.getModifiedBy() == null || partner.getModifiedBy().isEmpty()) {
			return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
					MessageConstant.MessageKey.BLANK_MODIFIED_BY, null, null);
		}

		finalResponse = new HashMap<>();
		finalResponse.put("validated", true);
		return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
				MessageConstant.MessageKey.SUCCESS_MESSAGE, finalResponse, null);
	}
//
//	public Map<String, Object> validateIds(String partnerIds) {
//		
//		String[] partnerIdList = partnerIds.split(",");
//		
//		for (String partnerId : partnerIdList) 
//			if(partnerId == null || partnerId.isBlank()) {
//				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
//						MessageConstant.MessageKey.BLANK_FIELD_ID, null, null);
//			}
//		}
//	
//		finalResponse = new HashMap<>();
//		finalResponse.put("validated", true);
//		return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
//				MessageConstant.MessageKey.SUCCESS_MESSAGE, finalResponse, null);
//	}

}
