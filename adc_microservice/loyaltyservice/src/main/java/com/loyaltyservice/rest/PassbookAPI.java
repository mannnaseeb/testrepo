package com.loyaltyservice.rest;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.loyaltyservice.constant.Constant;
import com.loyaltyservice.constant.UrlConstant;
import com.loyaltyservice.model.Passbook;
import com.loyaltyservice.service.PassbookService;
import com.loyaltyservice.utill.MessageConstant;
import com.loyaltyservice.utill.ResponseMessage;
import com.loyaltyservice.utill.ToolBox;
import com.loyaltyservice.validator.LoyaltyValidation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = UrlConstant.Basic.BASE_URL)
public class PassbookAPI {
	private static final Logger log = LoggerFactory.getLogger(EventAPI.class);

	@Autowired
	private PassbookService passbookService;

	@Autowired
	private LoyaltyValidation loyaltyValidation;

	@Autowired
	private ToolBox toolBox;

	/**
	 * userStoryId: ADCPI-640 
	 * Summary:BE :Get Passbook detail 
	 * Comment: This methodis used to get balance form passbook
	 * @param customerId
	 * @param transactionId
	 * @param limit
	 * @param offset
	 * @param orderBy
	 * @return
	 * @throws JsonProcessingException
	 * @throws ParseException
	 */
	@GetMapping(path = UrlConstant.URL.GET_PASSBOOK, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getPassbook(
			@RequestParam(value = Constant.CUSTOMER_ID, required = false) String customerId,
			@RequestParam(value = Constant.TRANSACTION_ID, required = false) String transactionId,
			@RequestParam(value = Constant.LIMT, required = false, defaultValue = "10") Long limit,
			@RequestParam(value = Constant.OFFSET, required = false, defaultValue = "0") Long offset,
			@RequestParam(value = Constant.ORDER_BY, required = false, defaultValue = "transactionId") String orderBy,
			@RequestParam(value = Constant.SORT_BY, required = false, defaultValue = "desc") String sortType)
			throws JsonProcessingException, ParseException {

		List<Passbook> passbooks = null;

		// Validate product fields
		Map<String, Object> fieldResponse = loyaltyValidation.validateCustomerId(customerId);
		if ((int) fieldResponse.get("status") == MessageConstant.Status.BAD_REQUEST) {
			return fieldResponse;
		}

		// Validating reward id, name and points
		if (null != customerId) {
			if (!toolBox.validateIdChecker(customerId))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_CUSTOMER_ID, null, null);
		}
		if (null != transactionId) {
			if (!toolBox.validateIdChecker(transactionId))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_TRANSACTION_ID, null, null);
		}

		passbooks = passbookService.getPassbook(customerId, transactionId, limit, offset, orderBy, sortType);
		log.info("PassbookAPI->[getPassbook] ::", passbooks);
		
		if (null != passbooks && !passbooks.isEmpty()) {
			Long totalCount = passbookService.getPassbookCount(customerId, transactionId);
			return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
					MessageConstant.MessageKey.FETCH_DATA, passbooks, totalCount);
		}
		if (!CollectionUtils.isEmpty(passbooks)) {
			return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
					MessageConstant.MessageKey.FETCH_DATA, passbooks, null);
		}
		return ResponseMessage.responses(MessageConstant.Status.DATA_NOT_FOUND_STATUS,
				MessageConstant.MessageKey.DATA_NOT_FOUND, null, 0L);
	}
}
