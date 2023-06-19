package com.loyaltyservice.utill;

import java.util.HashMap;
import java.util.Map;

public class ResponseMessage {

	public static Map<String,Object> responses(int status, String message, Object data, Long totalCount)
    {
        Map<String ,Object> result=new HashMap<>();

        	result.put("status",status);
            result.put("message",MessageConstant.message.get(message));
            result.put("message code",MessageConstant.messageCode.get(message));
            result.put("totalCount",totalCount);
            if(data!=null)
            result.put("data",data);

        return result;
    }
}
