package com.loyaltyservice.rest;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loyaltyservice.constant.Constant;
import com.loyaltyservice.constant.UrlConstant;
import com.loyaltyservice.model.LeaderBoardPoint;
import com.loyaltyservice.model.ResponseBean;
import com.loyaltyservice.service.LeaderBoardPointService;
import com.loyaltyservice.utill.ToolBox;
import com.loyaltyservice.validator.LoyaltyValidation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = UrlConstant.Basic.BASE_URL)
public class LeaderBoardPointAPI {
	
	private static final Logger log = LoggerFactory.getLogger(TaskAPI.class);

	@Autowired
	private LeaderBoardPointService leaderBoardPointService;

	@Autowired
	private LoyaltyValidation loyaltyValidation;

	@Autowired
	private ToolBox toolBox;
	
	@Autowired
	private ObjectMapper objectMapper;

	@Value("${partnerServiceURL}")
	private String partnerServiceURL;

	List<LeaderBoardPoint> leaderBoardPoints = null;

	/**
	 * 
	 * userStoryId: ADCPI-376 Summary:BE : Get leader board point details Comment:
	 * This method is used to get leader board point
	 * 
	 * @param partnerId
	 * @param rank
	 * @param transactionId
	 * @param limit
	 * @param offset
	 * @param orderBy
	 * @param sortType
	 * @return
	 * @throws JsonProcessingException
	 * @throws ParseException
	 */
	@SuppressWarnings("unchecked")
	@GetMapping(path = UrlConstant.URL.GET_LEADER_BOARD_POINT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBean> getLeaderBoardPoints(
			@RequestHeader(UrlConstant.Header.AUTH) String authorization,
			@RequestParam(value = Constant.CUSTOMER_ID, required = false) Long customerId,
			@RequestParam(value = Constant.PARTNER_ID, required = false) Long partnerIds,
			@RequestParam(value = Constant.TRANSACTION_ID, required = false) Long transactionId,
			@RequestParam(value = Constant.LIMT, required = false, defaultValue = "10") Long limit,
			@RequestParam(value = Constant.OFFSET, required = false, defaultValue = "0") Long offset,
			@RequestParam(value = Constant.ORDER_BY, required = false, defaultValue = "transactionId") String orderBy,
			@RequestParam(value = Constant.SORT_BY, required = false, defaultValue = "desc") String sortType)
			throws JsonProcessingException, ParseException {
		
		ResponseEntity<ResponseBean> partners = leaderBoardPointService.getPartners(authorization, partnerServiceURL, customerId,partnerIds,transactionId);		 
		return partners;

	}
	
	/**
	 * 
	 * userStoryId: ADCPI-376 Summary:BE : Get leader board point details Comment:
	 * This method is used to get leader board point
	 * 
	 * @param partnerId
	 * @param rank
	 * @param transactionId
	 * @param limit
	 * @param offset
	 * @param orderBy
	 * @param sortType
	 * @return
	 * @throws JsonProcessingException
	 * @throws ParseException
	 */
	@SuppressWarnings("unchecked")
	@GetMapping(path = UrlConstant.URL.GET_POINT_REDEMPTION_POINT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBean> getPointRedeemption(
			//@RequestHeader(UrlConstant.Header.AUTH) String authorization,
			@RequestParam(value = Constant.CUSTOMER_ID, required = false) Long customerId,
			//@RequestParam(value = Constant.PARTNER_ID, required = true) Long partnerIds,
			@RequestParam(value = Constant.TRANSACTION_ID, required = false) Long transactionId,
			@RequestParam(value = Constant.LIMT, required = false, defaultValue = "10") Long limit,
			@RequestParam(value = Constant.OFFSET, required = false, defaultValue = "0") Long offset,
			@RequestParam(value = Constant.ORDER_BY, required = false, defaultValue = "transactionId") String orderBy,
			@RequestParam(value = Constant.SORT_BY, required = false, defaultValue = "desc") String sortType)
			throws JsonProcessingException, ParseException {
		
		ResponseEntity<ResponseBean> redemptionPoints = leaderBoardPointService.getPointsRedemption(partnerServiceURL, customerId,transactionId);		 
		return redemptionPoints;

	}
}
