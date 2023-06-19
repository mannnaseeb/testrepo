package com.loyaltyservice.rest;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
import com.loyaltyservice.model.Coupon;
import com.loyaltyservice.model.EarnLoyaltyPoint;
import com.loyaltyservice.service.CouponService;
import com.loyaltyservice.utill.JsonUtility;
import com.loyaltyservice.utill.MessageConstant;
import com.loyaltyservice.utill.ResponseMessage;
import com.loyaltyservice.utill.ToolBox;
import com.loyaltyservice.validator.LoyaltyValidation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = UrlConstant.Basic.BASE_URL)
public class CouponAPI {
	
	private static final Logger log = LoggerFactory.getLogger(EventAPI.class);
	
	@Autowired
	private CouponService couponService;
	
	@Autowired
	private LoyaltyValidation loyaltyValidation;

	@Autowired
	private ToolBox toolBox;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private JsonUtility jsonUtility;

	
	Map<String, Object> responseMap = null;
	Map<String, Object> rewardMap = null;
	EarnLoyaltyPoint earnLoyaltyPoint = null;
	List<Map<String, Object>> responseMapList = new ArrayList<>();
	
	/**
	 * userStoryId:ADCPI-445 
	 * Summary:BE :Create gift vouchers 
	 * Comment: This method is used to create the gift voucher
	 * @param reward
	 * @return
	 * @throws JsonProcessingException
	 * @throws ParseException
	 */
	@PostMapping(path = UrlConstant.URL.CREATE_COUPON, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> createCoupon(@RequestBody String rewardRequestPalyload)
			throws JsonProcessingException, ParseException {

		log.info("Reward data:" + objectMapper.writeValueAsString(rewardRequestPalyload));

		Map<String, Object> responseMap = null;
		Coupon coupon = null;

		responseMap = jsonUtility.validateRewardRequestPalyload(rewardRequestPalyload);
		if (null != responseMap) {
			return responseMap;
		}

		ObjectMapper objectMapper = new ObjectMapper();
		coupon = objectMapper.readValue(rewardRequestPalyload, Coupon.class);

		// Validate loyalty fields 'name' and 'points'
		Map<String, Object> fieldResponse = loyaltyValidation.validateCreateProduct(coupon);
		if ((int) fieldResponse.get("status") == MessageConstant.Status.BAD_REQUEST) {
			return fieldResponse;
		}

		try {
			// Checking rejax pattern for reward 'points' and 'name'
			if (null != coupon.getName()) {
				if (!toolBox.validateNameChecker(coupon.getName()))
					return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
							MessageConstant.MessageKey.INAVLID_REWARD_NAME, null, null);

			}

			if (null != coupon.getRule().getRuleCalc()) {
				if (!toolBox.validateIdChecker(String.valueOf(coupon.getRule().getRuleCalc())))
					return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
							MessageConstant.MessageKey.INAVLID_REWARD_POINT, null, null);
			}

			/*if (EventType.EARN.name().equals(coupon.getRewardType())) {
				coupon.setRewardType(coupon.getRewardType());
			} else if (EventType.REDEEM.name().equals(coupon.getRewardType())) {
				coupon.setRewardType(coupon.getRewardType());
			} else if (EventType.ADJUST.name().equals(coupon.getRewardType())) {
				coupon.setRewardType(coupon.getRewardType());
			}*/

			// Add coupon
			couponService.createCoupon(coupon);
			rewardMap = new HashMap<>(5);
			rewardMap.put("name", coupon.getName());
			rewardMap.put("description", coupon.getDescription());
			rewardMap.put("points", coupon.getRule().getRuleCalc());
			rewardMap.put("created_by", coupon.getCreatedBy());
			rewardMap.put("last_updated", coupon.getModifiedBy());
			rewardMap.put("coupon_type", coupon.getEvetType());

			log.info("Loyalty detail: "+ rewardMap);
			return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
					MessageConstant.MessageKey.SUCCESS_MESSAGE, rewardMap, null);

		} catch (Exception ex) {
			return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
					MessageConstant.MessageKey.UNSUCCESS_MESSAGE, null, null);
		}
	}
	
	/**
	 * userStoryId: ADCPI-445 
	 * Summary:BE :Get gift vouchers 
	 * Comment: This method is used to get the gift voucher
	 * @param id
	 * @param name
	 * @return
	 * @throws JsonProcessingException
	 * @throws ParseException
	 */
	@GetMapping(path = UrlConstant.URL.GET_COUPON, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getCoupon(@RequestParam(value = Constant.COUPON_ID, required = false) Long couponId,
			@RequestParam(value = Constant.COUPON_NAME, required = false) String couponName,
			@RequestParam(value = Constant.EVENT_TYPE_ID, required = false) Long eventTypeId,
			@RequestParam(value = Constant.RULE_ID, required = false) Long ruleId,
			@RequestParam(value = Constant.CAMPAIGN_ID, required = false) Long campaignId,
			@RequestParam(value = Constant.LIMT, required = false, defaultValue = "20") Long limit,
			@RequestParam(value = Constant.OFFSET, required = false, defaultValue = "0") Long offset,
			@RequestParam(value = Constant.ORDER_BY, required = false, defaultValue = "couponId") String orderBy)
					throws JsonProcessingException, ParseException {

		List<Coupon> coupons = null;

		// Validating reward id, name and points
		if (null != couponId) {
			if (!toolBox.validateIdChecker(String.valueOf(couponId)))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_COUPON_ID, null, null);
		}

		if (null != couponName) {
			if (!toolBox.validateNameChecker(couponName))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_COUPON_NAME, null, null);
		}

		if (null != eventTypeId) {
			if (!toolBox.validateNameChecker(String.valueOf(eventTypeId)))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_REWARD_TYPE, null, null);
		}

		coupons = couponService.getCoupon(couponId, couponName, eventTypeId, ruleId, campaignId, limit, offset, orderBy);
		log.info("Coupon list: "+ coupons);


		Long totalCount = Long.valueOf(coupons.size());
		return (null != coupons && coupons.size() > 0)
				? ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
						MessageConstant.MessageKey.FETCH_DATA, coupons, totalCount)
						: ResponseMessage.responses(MessageConstant.Status.DATA_NOT_FOUND_STATUS,
								MessageConstant.MessageKey.DATA_NOT_FOUND, null, 0L);
	}
}
