package com.loyaltyservice.rest;

import java.lang.System.Logger.Level;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loyaltyservice.constant.Constant;
import com.loyaltyservice.constant.UrlConstant;
import com.loyaltyservice.model.Transaction;
import com.loyaltyservice.service.TransactionService;
import com.loyaltyservice.utill.JsonUtility;
import com.loyaltyservice.utill.MessageConstant;
import com.loyaltyservice.utill.ResponseMessage;
import com.loyaltyservice.utill.ToolBox;
import com.loyaltyservice.validator.LoyaltyValidation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = UrlConstant.Basic.BASE_URL)
public class TransactionAPI {

	private static final Logger log = LoggerFactory.getLogger(TransactionAPI.class);

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private LoyaltyValidation loyaltyValidation;

	@Autowired
	private ToolBox toolBox;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private JsonUtility jsonUtility;

	@PostMapping(path = UrlConstant.URL.CREATE_TRANSACTION, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createReward(@RequestBody Transaction transaction)
			throws JsonProcessingException, ParseException {
		try {
			transactionService.createTransaction(transaction);
			return new ResponseEntity<String>("Success", HttpStatus.CREATED);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}

	/**
	 * 
	 * userStoryId: ADCPI-764 
	 * Summary:BE : Get transaction history for loyalty
	 * program Comment: This method is used maintain the transaction against the
	 * loyalty point and coupon
	 * 
	 * @param transactionId
	 * @param customerId
	 * @param eventId
	 * @param limit
	 * @param offset
	 * @param orderBy
	 * @return
	 * @throws JsonProcessingException
	 * @throws ParseException
	 * 
	 */
	@GetMapping(path = UrlConstant.URL.GET_TRANSACTION, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getTransaction(
			@RequestParam(value = Constant.TRANSACTION_ID, required = false) Long transactionId,
			@RequestParam(value = Constant.CUSTOMER_ID, required = false) Long customerId,
			@RequestParam(value = Constant.EVENT_ID, required = false) Long eventId,
			@RequestParam(value = Constant.LIMT, required = false, defaultValue = "20") Long limit,
			@RequestParam(value = Constant.OFFSET, required = false, defaultValue = "0") Long offset,
			@RequestParam(value = Constant.ORDER_BY, required = false, defaultValue = "transactionId") String orderBy)
			throws JsonProcessingException, ParseException {

		List<Transaction> transactions = null;

		// checking rejax pattern
		if (null != transactionId) {
			if (!toolBox.validateIdChecker(String.valueOf(transactionId)))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_TRANSACTION_ID, null, null);
		}
		if (null != customerId) {
			if (!toolBox.validateIdChecker(String.valueOf(customerId)))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_CUSTOMER_ID, null, null);
		}
		if (null != eventId) {
			if (!toolBox.validateIdChecker(String.valueOf(eventId)))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_EVENT_ID, null, null);
		}

		try {
			transactions = transactionService.getTransaction(transactionId, customerId, eventId, limit, offset,
					orderBy);
			log.info("Just a stack trace, If error found in getTransaction()!!!");
			if (null != transactions && !transactions.isEmpty()) {
				Long totalCount = transactionService.getTransactionCount(transactionId, customerId, eventId);
				return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
						MessageConstant.MessageKey.FETCH_DATA, transactions, totalCount);
			}
		} catch (Exception ex) {
			//((java.lang.System.Logger) log).log(Level.INFO, "Got an exception.", ex);
		}
		
		return ResponseMessage.responses(MessageConstant.Status.DATA_NOT_FOUND_STATUS,
				MessageConstant.MessageKey.DATA_NOT_FOUND, null, 0L);
	}

}
