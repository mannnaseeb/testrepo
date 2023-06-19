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
import com.productcatalogue.entity.CountryEntity;
import com.productcatalogue.service.CountryService;
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
public class CountryAPI {

	@Autowired
	private CountryService countryService;

	/**
	 * Get the partner category
	 * 
	 * @return
	 */
	@GetMapping(path = UrlConstant.URL.GET_COUNTRY, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getCountry(@RequestParam(value = Constant.COUNTRY_ID, required = false) Long countryId)
			throws JsonProcessingException, ParseException {

		List<CountryEntity> countries = null;
		CountryEntity country = null;
		
		if (null == countryId) {
			countries = countryService.getAllCountry();
		} else {
			countries = new ArrayList<>();
			country = countryService.getCountryByCountryId(countryId);
			if(null != country)
				countries.add(country);
		}

		
		if (!countries.isEmpty()) {
			Long totalCount = Long.valueOf(countries.size());
			return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS, MessageConstant.MessageKey.FETCH_DATA,
					countries, totalCount);
		}
		return ResponseMessage.responses(MessageConstant.Status.DATA_NOT_FOUND_STATUS,
				MessageConstant.MessageKey.DATA_NOT_FOUND, null, 0L);
	}

}
