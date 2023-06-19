package com.loyaltyservice.utill;

import static com.loyaltyservice.utill.MessageConstant.MessageKey.BLANK_COUPON_ID;
import static com.loyaltyservice.utill.MessageConstant.MessageKey.BLANK_COUPON_NAME;
import static com.loyaltyservice.utill.MessageConstant.MessageKey.BLANK_COUPON_POINT;
import static com.loyaltyservice.utill.MessageConstant.MessageKey.BLANK_FIELD_CUSTOMER_ID;
import static com.loyaltyservice.utill.MessageConstant.MessageKey.BLANK_REWARD_ID;
import static com.loyaltyservice.utill.MessageConstant.MessageKey.BLANK_REWARD_NAME;
import static com.loyaltyservice.utill.MessageConstant.MessageKey.BLANK_REWARD_POINT;
import static com.loyaltyservice.utill.MessageConstant.MessageKey.BLANK_REWARD_TYPE;
import static com.loyaltyservice.utill.MessageConstant.MessageKey.DATA_NOT_FOUND;
import static com.loyaltyservice.utill.MessageConstant.MessageKey.FAILED_TASK_UNSUCCESS_MESSAGE;
import static com.loyaltyservice.utill.MessageConstant.MessageKey.FETCH_DATA;
import static com.loyaltyservice.utill.MessageConstant.MessageKey.INAVLID_COUPON_ID;
import static com.loyaltyservice.utill.MessageConstant.MessageKey.INAVLID_COUPON_NAME;
import static com.loyaltyservice.utill.MessageConstant.MessageKey.INAVLID_COUPON_POINT;
import static com.loyaltyservice.utill.MessageConstant.MessageKey.INAVLID_CUSTOMER_ID;
import static com.loyaltyservice.utill.MessageConstant.MessageKey.INAVLID_EVENT_ID;
import static com.loyaltyservice.utill.MessageConstant.MessageKey.INAVLID_REWARD_ID;
import static com.loyaltyservice.utill.MessageConstant.MessageKey.INAVLID_REWARD_NAME;
import static com.loyaltyservice.utill.MessageConstant.MessageKey.INAVLID_REWARD_POINT;
import static com.loyaltyservice.utill.MessageConstant.MessageKey.INAVLID_REWARD_TYPE;
import static com.loyaltyservice.utill.MessageConstant.MessageKey.INAVLID_TASK_ID;
import static com.loyaltyservice.utill.MessageConstant.MessageKey.INAVLID_TRANSACTION_ID;
import static com.loyaltyservice.utill.MessageConstant.MessageKey.PAYLOAD_COUPON_NAME_MISSING;
import static com.loyaltyservice.utill.MessageConstant.MessageKey.PAYLOAD_COUPON_POINT_MISSING;
import static com.loyaltyservice.utill.MessageConstant.MessageKey.PAYLOAD_CREATED_BY_MISSING;
import static com.loyaltyservice.utill.MessageConstant.MessageKey.PAYLOAD_DESC_MISSING;
import static com.loyaltyservice.utill.MessageConstant.MessageKey.PAYLOAD_NAME_MISSING;
import static com.loyaltyservice.utill.MessageConstant.MessageKey.PAYLOAD_POINT_MISSING;
import static com.loyaltyservice.utill.MessageConstant.MessageKey.PAYLOAD_REWARD_TYPE_MISSING;
import static com.loyaltyservice.utill.MessageConstant.MessageKey.PAYLOAD_UPDATED_BY_MISSING;
import static com.loyaltyservice.utill.MessageConstant.MessageKey.SUCCESS_MESSAGE;
import static com.loyaltyservice.utill.MessageConstant.MessageKey.TASK_CREATED_SUCCESS_MESSAGE;
import static com.loyaltyservice.utill.MessageConstant.MessageKey.UNSUCCESS_MESSAGE;

import java.util.HashMap;
import java.util.Map;

public class MessageConstant {

	public static Map<String, Object> message = new HashMap<>();
	public static Map<String, Object> messageCode = new HashMap<>();

	public interface Status {
		
		int BAD_REQUEST = 400;
		int SUCCESS_STATUS = 200;
		int DATA_NOT_FOUND_STATUS= 404;
		int NOT_ACCEPTABLE = 406;
		int CREATED = 201;
		
	}

	public interface MessageKey {

		// -- message key --
		String SUCCESS_MESSAGE = "SUCCESS";
		String UNSUCCESS_MESSAGE = "UNSUCCESS";
		String TASK_CREATED_SUCCESS_MESSAGE = "SUCCESS";
		String FAILED_TASK_UNSUCCESS_MESSAGE = "UNSUCCESS";
		
		String FETCH_DATA = "Data Fetched";
		String DATA_NOT_FOUND = "No data found";
		
		String PAYLOAD_NAME_MISSING = "Payload name mising";
		String PAYLOAD_POINT_MISSING = "Payload point missing";
		String PAYLOAD_DESC_MISSING = "Payload desc missing"; 
		String PAYLOAD_CREATED_BY_MISSING = "Payload created by missing"; 
		String PAYLOAD_UPDATED_BY_MISSING = "Payload modified by missing"; 
		String PAYLOAD_COUPON_NAME_MISSING = "Payload name mising";
		String PAYLOAD_COUPON_POINT_MISSING = "Payload point missing";
		String PAYLOAD_COUPON_DESC_MISSING = "Payload desc missing"; 
		String PAYLOAD_COUPON_CREATED_BY_MISSING = "Payload created by missing"; 
		String PAYLOAD_COUPON_UPDATED_BY_MISSING = "Payload modified by missing"; 
		String PAYLOAD_REWARD_TYPE_MISSING = "Payload reward type by missing"; 
		
		String BLANK_REWARD_ID = "blank reward id";
		String BLANK_REWARD_NAME = "blank reward name";
		String BLANK_REWARD_POINT = "blank reward point";
		String BLANK_REWARD_TYPE = "blank reward point";
		String INAVLID_REWARD_ID = "invalid reward id";
		String INAVLID_REWARD_NAME = "invalid reward name";
		String INAVLID_REWARD_TYPE = "invalid reward type";
		String INAVLID_REWARD_POINT = "invalid reward point";
		
		String BLANK_COUPON_ID = "blank coupon id";
		String BLANK_COUPON_NAME = "blank coupon name";
		String BLANK_COUPON_POINT = "blank coupon point";
		String INAVLID_COUPON_ID = "invalid coupon id";
		String INAVLID_COUPON_NAME = "invalid coupon name";
		String INAVLID_COUPON_POINT = "invalid coupon point";
		
		String INAVLID_TRANSACTION_ID = "invalid transaction id"; 
		String INAVLID_CUSTOMER_ID = "invalid customer id";
		String INAVLID_EVENT_ID = "invalid event id";
		String BLANK_FIELD_CUSTOMER_ID = "blank customer id";
		
		String INAVLID_TASK_ID = "invalid task id";
	}

	static {

		// -- message constant --
		message.put(SUCCESS_MESSAGE, "Successfully save data"); // Successful 
		message.put(TASK_CREATED_SUCCESS_MESSAGE, "Successfully task created"); // Successful
		message.put(UNSUCCESS_MESSAGE, "Unable to save data"); // unsuccessful 
		message.put(FAILED_TASK_UNSUCCESS_MESSAGE, "Unable to save data"); // unsuccessful 
		message.put(DATA_NOT_FOUND, "Data not found"); // blank data
		message.put(FETCH_DATA, "Data fetch successfully"); // Fetch success
		
		message.put(BLANK_REWARD_ID, "Please enter the reward id"); // blank reward point
		message.put(BLANK_REWARD_NAME, "Please enter the reward name"); // blank reward name
		message.put(BLANK_REWARD_TYPE, "Please enter the reward type"); // blank reward type
		message.put(BLANK_REWARD_POINT, "Please enter the reward point"); // blank reward point
		message.put(BLANK_REWARD_TYPE, "Please enter the reward type"); // blank reward type
		message.put(INAVLID_REWARD_ID, "Please enter the correct reward id"); // invalid reward id
		message.put(INAVLID_REWARD_NAME, "Please enter the correct reward name"); // invalid reward name
		message.put(INAVLID_REWARD_POINT, "Please enter the correct reward point"); // invalid reward point
		
		message.put(BLANK_COUPON_ID, "Please enter the coupon id"); // blank reward point
		message.put(BLANK_COUPON_NAME, "Please enter the coupon name"); // blank reward name
		message.put(BLANK_COUPON_POINT, "Please enter the coupon point"); // blank reward point
		message.put(INAVLID_COUPON_ID, "Please enter the correct coupon id"); // invalid reward id
		message.put(INAVLID_COUPON_NAME, "Please enter the correct coupon name"); // invalid reward name
		message.put(INAVLID_COUPON_POINT, "Please enter the correct coupon point"); // invalid reward point
		
		message.put(PAYLOAD_NAME_MISSING, "Reward name is missing in payload"); // missing payload name
		message.put(PAYLOAD_POINT_MISSING, "Reward point is missing in payload"); // missing payload point
		message.put(PAYLOAD_DESC_MISSING, "Description is missing in payload"); // missing payload description
		message.put(PAYLOAD_CREATED_BY_MISSING, "Created by is missing in payload"); // missing payload created_by
		message.put(PAYLOAD_UPDATED_BY_MISSING, "Modified by is missing in payload"); // missing payload modified_by
		message.put(PAYLOAD_COUPON_NAME_MISSING, "Coupon name is missing in payload"); // missing payload name
		message.put(PAYLOAD_COUPON_POINT_MISSING, "Coupon point is missing in payload"); // missing payload point
		message.put(PAYLOAD_REWARD_TYPE_MISSING, "Reward type is missing in payload"); // missing payload reward type
		
		message.put(INAVLID_TRANSACTION_ID, "Please enter the correct transaction id"); // invalid transaction id
		message.put(INAVLID_CUSTOMER_ID, "Please enter the correct customer id"); // invalid customer id
		message.put(BLANK_FIELD_CUSTOMER_ID, "Please enter the customer id"); // blank id

		message.put(INAVLID_TASK_ID, "Please enter the correct task id"); // invalid task id
		message.put(INAVLID_EVENT_ID, "Please enter the event task id"); // invalid event id
		
		// -- message status --
		messageCode.put(SUCCESS_MESSAGE, 1001);
		messageCode.put(TASK_CREATED_SUCCESS_MESSAGE, 1023);
		messageCode.put(UNSUCCESS_MESSAGE, 1002); 
		messageCode.put(FAILED_TASK_UNSUCCESS_MESSAGE, 1024);
		
		messageCode.put(FETCH_DATA, 1003);
		messageCode.put(DATA_NOT_FOUND, 1004);
		
		messageCode.put(BLANK_REWARD_ID, 1005);
		messageCode.put(BLANK_REWARD_NAME, 1006);
		messageCode.put(BLANK_REWARD_POINT, 1007);
		messageCode.put(BLANK_REWARD_TYPE, 1019);
		messageCode.put(INAVLID_REWARD_ID, 1008);
		messageCode.put(INAVLID_REWARD_NAME, 1009);
		messageCode.put(INAVLID_REWARD_TYPE, 1020);
		messageCode.put(INAVLID_REWARD_POINT, 1010);
		
		messageCode.put(PAYLOAD_NAME_MISSING, 1011);
		messageCode.put(PAYLOAD_POINT_MISSING, 1012);
		messageCode.put(PAYLOAD_DESC_MISSING, 1013);
		messageCode.put(PAYLOAD_CREATED_BY_MISSING, 1014);
		messageCode.put(PAYLOAD_UPDATED_BY_MISSING, 1015);
		messageCode.put(PAYLOAD_COUPON_NAME_MISSING, 1016);
		messageCode.put(PAYLOAD_COUPON_POINT_MISSING, 1017);
		messageCode.put(PAYLOAD_REWARD_TYPE_MISSING, 1018);
		
		messageCode.put(INAVLID_TRANSACTION_ID, 1021);
		messageCode.put(INAVLID_CUSTOMER_ID, 1022);
		messageCode.put(INAVLID_EVENT_ID, 1027);
		
		messageCode.put(BLANK_FIELD_CUSTOMER_ID, 1026);
		
		messageCode.put(INAVLID_TASK_ID, 1024);
	}
}
