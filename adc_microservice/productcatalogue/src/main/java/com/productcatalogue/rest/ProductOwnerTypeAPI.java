package com.productcatalogue.rest;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.productcatalogue.constant.UrlConstant;
import com.productcatalogue.entity.ProductOwnerTypeEntity;
import com.productcatalogue.service.ProductOwnerTypeAPIService;
import com.productcatalogue.utils.MessageConstant;
import com.productcatalogue.utils.ResponseMessage;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author praveen.gairola
 *
 */
@Slf4j
@RestController
@RequestMapping(value = UrlConstant.Basic.BASE_URL)
public class ProductOwnerTypeAPI {

	@Autowired
	private ProductOwnerTypeAPIService productOwnerTypeAPIService;

	/**
	 * Get the product owner type information
	 * 
	 * @return
	 */
	@GetMapping(path = UrlConstant.URL.GET_PRODUCT_OWNER_TYPE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getAllProductOwnerType() throws JsonProcessingException, ParseException {

		List<ProductOwnerTypeEntity> productOwnerType = productOwnerTypeAPIService.getAllProductOwnerType();
		if (!productOwnerType.isEmpty()) {
			Long totalCount = Long.valueOf(productOwnerType.size());
			return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS, MessageConstant.MessageKey.FETCH_DATA, productOwnerType, totalCount);
		}
		return ResponseMessage.responses(MessageConstant.Status.DATA_NOT_FOUND_STATUS, MessageConstant.MessageKey.DATA_NOT_FOUND, null, 0L);
	}
}
