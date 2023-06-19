package com.loyaltyservice.utill;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class JsonUtility {

	Map<String, Object> responseMap = null;
	/**
	 * Converting String object to JSON data Validating to JSON payload
	 * 
	 * @param rewardRequestPalyload
	 * @return
	 */
	public Map<String, Object> validateRewardRequestPalyload(String rewardRequestPalyload) {

		JSONObject jsonObject = parsingToJson(rewardRequestPalyload);
		if (!jsonObject.has("name")) {
			responseMap = ResponseMessage.responses(MessageConstant.Status.NOT_ACCEPTABLE,
					MessageConstant.MessageKey.PAYLOAD_NAME_MISSING, null, null);
			return responseMap;
		}

//		if (!jsonObject.has("points")) {
//			responseMap = ResponseMessage.responses(MessageConstant.Status.NOT_ACCEPTABLE,
//					MessageConstant.MessageKey.PAYLOAD_POINT_MISSING, null, null);
//			return responseMap;
//		}
//		if (!jsonObject.has("createdBy")) {
//			responseMap = ResponseMessage.responses(MessageConstant.Status.NOT_ACCEPTABLE,
//					MessageConstant.MessageKey.PAYLOAD_CREATED_BY_MISSING, null, null);
//			return responseMap;
//		}
//		if (!jsonObject.has("modifiedBy")) {
//			responseMap = ResponseMessage.responses(MessageConstant.Status.NOT_ACCEPTABLE,
//					MessageConstant.MessageKey.PAYLOAD_UPDATED_BY_MISSING, null, null);
//			return responseMap;
//		}
//		if (!jsonObject.has("rewardType")) {
//			responseMap = ResponseMessage.responses(MessageConstant.Status.NOT_ACCEPTABLE,
//					MessageConstant.MessageKey.PAYLOAD_REWARD_TYPE_MISSING, null, null);
//			return responseMap;
//		}
		return responseMap;
	}

	public Map<String, Object> validateTaskPayload(String taskPayload) {
		JSONObject jsonObject = parsingToJson(taskPayload);
		if (!jsonObject.has("taskType")) {
			responseMap = ResponseMessage.responses(MessageConstant.Status.NOT_ACCEPTABLE,
					MessageConstant.MessageKey.PAYLOAD_NAME_MISSING, null, null);
			return responseMap;
		}
		
		if (!jsonObject.has("taskStatus")) {
			responseMap = ResponseMessage.responses(MessageConstant.Status.NOT_ACCEPTABLE,
					MessageConstant.MessageKey.PAYLOAD_NAME_MISSING, null, null);
			return responseMap;
		}

		return null;
	}

	public JSONObject parsingToJson(String palyloadLoyalty) {
		JSONObject jsonObject = new JSONObject(palyloadLoyalty);
		return jsonObject;
	}

}
