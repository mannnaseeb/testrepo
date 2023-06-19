package com.productcatalogue.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productcatalogue.constant.UrlConstant;
import com.productcatalogue.entity.PartnerSubcategoryEntity;
import com.productcatalogue.service.PartnerSubCategoryService;
import com.productcatalogue.utils.MessageConstant;
import com.productcatalogue.utils.ResponseMessage;

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
public class PartnerSubCategoryAPI {

	@Autowired
	private PartnerSubCategoryService prtnerSubCategoryservice;

	/**
	 * Get the product sub category
	 * 
	 * @return
	 */
	@GetMapping(path = UrlConstant.URL.GET_PARTNER_SUB_CATEGORY, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getAllPartnerSubCategory() {
		
		List<PartnerSubcategoryEntity> partnersubList = prtnerSubCategoryservice.getAllPartnerSubCategory();
		if (partnersubList.isEmpty()) {
			Long  totalCount = Long.valueOf(partnersubList.size());
			return ResponseMessage.responses(MessageConstant.Status.DATA_NOT_FOUND_STATUS, MessageConstant.MessageKey.DATA_NOT_FOUND, null, totalCount);
		}
		return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS, MessageConstant.MessageKey.FETCH_DATA, partnersubList, 0L);
	}
}
