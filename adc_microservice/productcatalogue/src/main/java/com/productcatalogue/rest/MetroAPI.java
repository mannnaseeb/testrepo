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
import com.productcatalogue.entity.MetroEntity;
import com.productcatalogue.service.MetroService;
import com.productcatalogue.utils.MessageConstant;
import com.productcatalogue.utils.ResponseMessage;

import lombok.extern.slf4j.Slf4j;

/**
 * @author praveen.gairola
 *
 */
@Slf4j
@CrossOrigin(origins = "*", allowCredentials = "false")
@RestController
@RequestMapping(value = UrlConstant.Basic.BASE_URL)
public class MetroAPI {

	@Autowired
	private MetroService metroService;

	/**
	 * Get the metro information
	 * 
	 * @return
	 */
	@GetMapping(path = UrlConstant.URL.GET_METRO, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getAllMetro(@RequestParam(value = Constant.METRO_ID, required = false) Long metroId)
			throws JsonProcessingException, ParseException {

		List<MetroEntity> metroList = null;
		MetroEntity metro = null;

		if (null == metroId) {
			metroList = metroService.getAllMetro();
		} else {
			metroList = new ArrayList<>();
			metro = metroService.getMetroByMetroId(metroId);
			if (null != metro)
				metroList.add(metro);
		}

		if (!metroList.isEmpty()) {
			Long  totalCount = Long.valueOf(metroList.size());
			return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
					MessageConstant.MessageKey.FETCH_DATA, metroList, totalCount);
		}
		return ResponseMessage.responses(MessageConstant.Status.DATA_NOT_FOUND_STATUS, MessageConstant.MessageKey.DATA_NOT_FOUND,
				null, 0L);
	}
}
