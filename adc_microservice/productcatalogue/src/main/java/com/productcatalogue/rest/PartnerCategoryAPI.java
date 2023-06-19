package com.productcatalogue.rest;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.productcatalogue.constant.UrlConstant;
import com.productcatalogue.entity.PartnerCategoryEntity;
import com.productcatalogue.service.PartnerCategoryService;
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
public class PartnerCategoryAPI {
	
	@Autowired
	private PartnerCategoryService partnerCategoryService;
	
	/**
	 * Get the partner category
	 * 
	 * @return
	 */
	@GetMapping(path = UrlConstant.URL.GET_PARTNER_CATEGORY, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getPartnerCategory() throws JsonProcessingException, ParseException {
		
		List<PartnerCategoryEntity> partList = partnerCategoryService.getAllPartnertype();
		if (!partList.isEmpty()) {
			Long totalCount = Long.valueOf(partList.size());
			return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS, MessageConstant.MessageKey.FETCH_DATA, partList, totalCount);
			
		}
		
		return ResponseMessage.responses(MessageConstant.Status.DATA_NOT_FOUND_STATUS, MessageConstant.MessageKey.DATA_NOT_FOUND, null, 0L);
	}

}
