package com.loyaltyservice.rest;

import java.text.ParseException;
import java.util.ArrayList;
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
import com.loyaltyservice.model.EarnLoyaltyPoint;
import com.loyaltyservice.model.Event;
import com.loyaltyservice.model.Redemptions;
import com.loyaltyservice.service.EventService;
import com.loyaltyservice.utill.JsonUtility;
import com.loyaltyservice.utill.MessageConstant;
import com.loyaltyservice.utill.ResponseMessage;
import com.loyaltyservice.utill.ToolBox;
import com.loyaltyservice.validator.LoyaltyValidation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = UrlConstant.Basic.BASE_URL)
public class EventAPI {

	private static final Logger log = LoggerFactory.getLogger(EventAPI.class);

	@Autowired
	private EventService eventService;

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
	 * userStoryId: ADCPI-640 
	 * Summary:BE :Create reward point for loyalty program
	 * Comment: This method is used to add reward point
	 * @param reward
	 * @return
	 * @throws JsonProcessingException
	 * @throws ParseException
	 */
	@PostMapping(path = UrlConstant.URL.CREATE_EVENT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> createEvent(@RequestBody String rewardRequestPalyload)
			throws JsonProcessingException, ParseException {

		log.info("Coupon data:" + objectMapper.writeValueAsString(rewardRequestPalyload));
		Event event = null;

		responseMap = jsonUtility.validateRewardRequestPalyload(rewardRequestPalyload);
		if (null != responseMap) {
			return responseMap;
		}

		ObjectMapper objectMapper = new ObjectMapper();
		event = objectMapper.readValue(rewardRequestPalyload, Event.class);

		log.info("Reward data:" + event);

		// Validate loyalty fields 'name' and 'points'
		Map<String, Object> fieldResponse = loyaltyValidation.validateCreateProduct(event);
		if ((int) fieldResponse.get("status") == MessageConstant.Status.BAD_REQUEST) {
			return fieldResponse;
		}

		try {
			// Checking rejax pattern for reward 'points' and 'name'
			if (null != event.getName()) {
				if (!toolBox.validateNameChecker(event.getName()))
					return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
							MessageConstant.MessageKey.INAVLID_REWARD_NAME, null, null);
			}

			if (null != event.getRule().getRuleCalc()) {
				if (!toolBox.validateIdChecker(String.valueOf(event.getRule().getRuleCalc())))
					return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
							MessageConstant.MessageKey.INAVLID_REWARD_POINT, null, null);
			}

			/*if (EventType.EARN.name().equals(event.getEvetType().getName())) {
				event.setRewardType(event.getEvetType().getName());
			} else if (EventType.REDEEM.name().equals(event.getEvetType().getName())) {
				event.setRewardType(event.getEvetType().getName());
			} else if (EventType.ADJUST.name().equals(event.getEvetType().getName())) {
				event.setRewardType(event.getEvetType().getName());
			}*/

			// Add the Loyalty Points to purchase Benefits.
			eventService.createEvent(event);
			log.info("Loyalty detail: "+ rewardMap);

			return ResponseMessage.responses(MessageConstant.Status.CREATED,
					MessageConstant.MessageKey.SUCCESS_MESSAGE, event, null);

		} catch (Exception ex) {
			return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
					MessageConstant.MessageKey.UNSUCCESS_MESSAGE, null, null);
		}
	}

	/**
	 * userStoryId: ADCPI-640 
	 * Summary:BE :Get reward points for loyalty program
	 * Comment: This method is used to fetch the reward points
	 * @param rewardId
	 * @param rewardName
	 * @return
	 * @throws JsonProcessingException
	 * @throws ParseException
	 */
	@GetMapping(path = UrlConstant.URL.GET_EVENT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getEvent(
			@RequestParam(value = Constant.EVENT_ID, required = false) Long eventId,
			@RequestParam(value = Constant.EVENT_NAME, required = false) String eventName,
			@RequestParam(value = Constant.EVENT_TYPE_ID, required = false) Long eventTypeId,
			@RequestParam(value = Constant.RULE_ID, required = false) Long ruleId,
			@RequestParam(value = Constant.CAMPAIGN_ID, required = false) Long campaignId,
			@RequestParam(value = Constant.LIMT, required = false, defaultValue = "20") Long limit,
			@RequestParam(value = Constant.OFFSET, required = false, defaultValue = "0") Long offset,
			@RequestParam(value = Constant.ORDER_BY, required = false, defaultValue = "eventId") String orderBy)
					throws JsonProcessingException, ParseException {

		List<Event> events = null;

		// Validating reward id, name and points
		if (null != eventId) {
			if (!toolBox.validateIdChecker(String.valueOf(eventId)))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_REWARD_ID, null, null);
		}

		if (null != eventName) {
			if (!toolBox.validateNameChecker(eventName))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_REWARD_NAME, null, null);
		}

		if (null != eventTypeId) {
			if (!toolBox.validateNameChecker(String.valueOf(eventTypeId)))
				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
						MessageConstant.MessageKey.INAVLID_REWARD_TYPE, null, null);
		}

		// Fetch rewards
		events = eventService.getEvent(eventId, eventName, eventTypeId, ruleId, campaignId, limit, offset, orderBy);
		log.info("Reward list data: "+ events);

		Long totalCount = Long.valueOf(events.size());
		return (null != events && events.size() > 0)
				? ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
						MessageConstant.MessageKey.FETCH_DATA, events, totalCount)
						: ResponseMessage.responses(MessageConstant.Status.DATA_NOT_FOUND_STATUS,
								MessageConstant.MessageKey.DATA_NOT_FOUND, null, 0L);
	}
	
	/**
	 * Create product
	 * 
	 * @param productModel
	 * @return
	 * @throws JsonProcessingException
	 * @throws ParseException
	 */
	@PostMapping(path = UrlConstant.URL.CREATE_REDEEM_REQUEST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> createRedeemption(@RequestBody Redemptions redemptions)
			throws JsonProcessingException, ParseException {

		log.info("Create new product", redemptions);

		// Validate product fields
		Map<String, Object> fieldResponse = loyaltyValidation.validateCreateRedeemptions(redemptions);
		if ((int) fieldResponse.get("status") == MessageConstant.Status.BAD_REQUEST) {
			return fieldResponse;
		}
//
//		// Validating id should be in digit and name
//		if (null != product.getProductId()) {
//			if (!toolBox.validateIdChecker(product.getProductId()))
//				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
//						MessageConstant.MessageKey.INAVLID_PRODUCT_ID, null, null);
//		} else if (null != product.getName()) {
//			if (!toolBox.validateNameChecker(product.getName()))
//				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
//						MessageConstant.MessageKey.INAVLID_PRODUCT_NAME, null, null);
//		}

		eventService.createRedeemption(redemptions);
		return ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
				MessageConstant.MessageKey.SUCCESS_MESSAGE, redemptions, null);
	}
	

	/**
	 * userStoryId: ADCPI-706 
	 * Summary:BE :How to Earn Loyalty Points
	 * Comment: This method is used to redeem the point 
	 * @return
	 * @throws JsonProcessingException
	 * @throws ParseException
	 */
	/*
	 * @GetMapping(path = UrlConstant.URL.EARN_LOYALTY_POINT, produces =
	 * MediaType.APPLICATION_JSON_VALUE) public ResponseEntity<String>
	 * getEarnLoyaltyPoints() throws JsonProcessingException, ParseException {
	 * 
	 * List<EarnLoyaltyPoint> listELoyaltyPoints = new ArrayList<>();
	 * 
	 * List<Event> rewardPoints = rewardService.earnLoyaltyPoints(); for (Event
	 * reward : rewardPoints) { EarnLoyaltyPoint earnLoyaltyPoint = new
	 * EarnLoyaltyPoint(); earnLoyaltyPoint.setLoyaltyName(reward.getName());
	 * earnLoyaltyPoint.setLoyaltyPoint(reward.getPoints());
	 * listELoyaltyPoints.add(earnLoyaltyPoint); }
	 * 
	 * ResponseBean response = new ResponseBean();
	 * response.setData(listELoyaltyPoints); response.setStatus("SUCCESS");
	 * response.setMessage("Data fetch successfully");
	 * response.setStatusCode("200"); return
	 * ResponseEntity.ok(objectMapper.writeValueAsString(response));
	 * 
	 * }
	 */
}

