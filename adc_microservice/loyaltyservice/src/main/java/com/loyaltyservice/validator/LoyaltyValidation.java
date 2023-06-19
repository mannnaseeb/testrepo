package com.loyaltyservice.validator;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.loyaltyservice.model.Coupon;
import com.loyaltyservice.model.Event;
import com.loyaltyservice.model.Redemptions;
import com.loyaltyservice.utill.MessageConstant;
import com.loyaltyservice.utill.ResponseMessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LoyaltyValidation {

	private static final Logger logger = LoggerFactory.getLogger(LoyaltyValidation.class);

	Map<String, Object> finalResponse;
	
	@SuppressWarnings("unlikely-arg-type")
	public Map<String, Object> validateCreateProduct(Event event) {

		if (null == event.getName() || event.getName().isEmpty()) {
			return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
					MessageConstant.MessageKey.BLANK_REWARD_NAME, null, null);
		} else if (null == event.getRule().getRuleCalc() || event.getRule().getRuleCalc().equals("")) {
			return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
					MessageConstant.MessageKey.BLANK_REWARD_POINT, null, null);
		} else if (null == event.getEvetType() || event.getEvetType().equals("")) {
			return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
					MessageConstant.MessageKey.BLANK_REWARD_POINT, null, null);
		}

		finalResponse = new HashMap<>();
		finalResponse.put("validated", true);
		return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
				MessageConstant.MessageKey.SUCCESS_MESSAGE, finalResponse, null);
	}

	@SuppressWarnings("unlikely-arg-type")
	public Map<String, Object> validateCreateProduct(Coupon coupon) {

		if (null == coupon.getName() || coupon.getName().isEmpty()) {
			return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
					MessageConstant.MessageKey.BLANK_REWARD_NAME, null, null);
		} else if (null == coupon.getRule().getRuleCalc() || coupon.getRule().getRuleCalc().equals("")) {
			return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
					MessageConstant.MessageKey.BLANK_REWARD_POINT, null, null);
		} else if (null == coupon.getEvetType() || coupon.getEvetType().equals("")) {
			return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
					MessageConstant.MessageKey.BLANK_REWARD_POINT, null, null);
		}

		finalResponse = new HashMap<>();
		finalResponse.put("validated", true);
		return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
				MessageConstant.MessageKey.SUCCESS_MESSAGE, finalResponse, null);
	}

	public Map<String, Object> validateCustomerId(String customerId) {
		if (customerId == null || customerId.isBlank() ) {
			return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
					MessageConstant.MessageKey.BLANK_FIELD_CUSTOMER_ID, null, null);
		}
		finalResponse = new HashMap<>();
		finalResponse.put("validated", true);
		return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
				MessageConstant.MessageKey.SUCCESS_MESSAGE, finalResponse, null);
	}

	public Map<String, Object> validateCreateRedeemptions(Redemptions redemptionsRequest) {
		return null;
	}
}