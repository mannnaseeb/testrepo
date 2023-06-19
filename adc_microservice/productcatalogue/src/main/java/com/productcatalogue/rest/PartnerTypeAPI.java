package com.productcatalogue.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productcatalogue.constant.UrlConstant;
import com.productcatalogue.entity.PartnertypeEntity;
import com.productcatalogue.service.PartnertypeService;

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
public class PartnerTypeAPI {

	@Autowired
	private PartnertypeService partnertypeEntityService;

	/**
	 * Get the Type of Partner form locations
	 * 
	 * @return
	 */
	@GetMapping(UrlConstant.URL.GET_PARTNER_TYPE)
	List<PartnertypeEntity> getAllPartnertype() {
		return partnertypeEntityService.getAllPartnertype();
	}
}
