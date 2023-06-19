package com.productcatalogue.rest;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.productcatalogue.constant.Constant;
import com.productcatalogue.constant.UrlConstant;
import com.productcatalogue.entity.CampusEntity;
import com.productcatalogue.service.CampusService;
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
public class CampusAPI {

	@Autowired
	private CampusService campusService;

	/**
	 * Get the partner category
	 * 
	 * @return
	 */
	@GetMapping(path = UrlConstant.URL.GET_CAMPUS, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getAllCampus(
			@RequestParam(value = Constant.CAMPUS_ID, required = false) Long campusId)
			throws JsonProcessingException, ParseException {
		Long totalCount = null;
		List<CampusEntity> campus = null;
		CampusEntity camp = null;
		if (null == campusId) {
			campus = campusService.getAllCampus();
			totalCount = campusService.getCampusCount();
		} else {
			campus = new ArrayList<>();
			camp = campusService.getCampusByCampusId(campusId);
			totalCount = campusService.getCampusCountById(campusId);
			if(null != campusId)
				campus.add(camp);
		}
		
		if (!campus.isEmpty()) {
			return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS, MessageConstant.MessageKey.FETCH_DATA,
					campus, totalCount);
		}
		return ResponseMessage.responses(MessageConstant.Status.DATA_NOT_FOUND_STATUS,
				MessageConstant.MessageKey.DATA_NOT_FOUND, null, 0L);
	}
}
