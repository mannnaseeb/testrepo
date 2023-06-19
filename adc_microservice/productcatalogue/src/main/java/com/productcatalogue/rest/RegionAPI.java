package com.productcatalogue.rest;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.productcatalogue.entity.RegionEntity;
import com.productcatalogue.service.RegionService;
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
public class RegionAPI {

	private static final Logger logger = LoggerFactory.getLogger(RegionAPI.class);

	@Autowired
	private RegionService regionService;

	@Autowired
	private ProductValidation productValidation;

	@Autowired
	private ToolBox toolBox;

	/**
	 * Get the region information
	 * 
	 * @return
	 */
	@GetMapping(path = UrlConstant.URL.GET_REGION, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getAllRegion(@RequestParam(value = Constant.REGION_ID, required = false) Long regionId)
			throws JsonProcessingException, ParseException {

		List<RegionEntity> regions = null;
		RegionEntity region = null;
		if (null == regionId) {
			regions = regionService.getAllRegion();
		} else {
			regions = new ArrayList<>();
			region = regionService.getRegionByRegionId(regionId);
			if(null != region)
				regions.add(region);
		}
		
		if (!regions.isEmpty()) {
			Long totalCount = Long.valueOf(regions.size());
			return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
					MessageConstant.MessageKey.FETCH_DATA, regions, totalCount);
		}
		return ResponseMessage.responses(MessageConstant.Status.DATA_NOT_FOUND_STATUS, MessageConstant.MessageKey.DATA_NOT_FOUND,
				null, 0L);
	}
}
