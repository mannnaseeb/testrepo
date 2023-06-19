package com.loyaltyservice.rest;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.loyaltyservice.model.EarnLoyaltyPoint;
import com.loyaltyservice.model.Task;
import com.loyaltyservice.service.TaskService;
import com.loyaltyservice.utill.JsonUtility;
import com.loyaltyservice.utill.MessageConstant;
import com.loyaltyservice.utill.ResponseMessage;
import com.loyaltyservice.utill.ToolBox;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = UrlConstant.Basic.BASE_URL)
public class TaskAPI {
	
	private static final Logger log = LoggerFactory.getLogger(TaskAPI.class);

	@Autowired
	private TaskService taskService;

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

	@GetMapping(value = "")
	public String index() {
		log.info("TaskAPI-> [loyalty] ::::" + "LOYALTY API");
		return "Task API";
	}

	/**
	 * userStoryId: ADCPI-382 Summary:BE : Create task Comment: This method is used
	 * to create task for loyalty program
	 * 
	 * @param task
	 * @return
	 * @throws JsonProcessingException
	 * @throws ParseException
	 */
	@PostMapping(path = UrlConstant.URL.CREATE_TASK, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> createTask(@RequestBody String taskPayload)
			throws JsonProcessingException, ParseException {

		try {
			log.info("TaskAPI->[createTask]::" + objectMapper.writeValueAsString(taskPayload));
			Task task = null;

			responseMap = jsonUtility.validateTaskPayload(taskPayload);
			if (null != responseMap) {
				return responseMap;
			}

			ObjectMapper objectMapper = new ObjectMapper();
			task = objectMapper.readValue(taskPayload, Task.class);

			log.info("Task:" + task);

			taskService.createTask(task);
			log.info("Loyalty detail: " + task);

			return ResponseMessage.responses(MessageConstant.Status.CREATED,
					MessageConstant.MessageKey.TASK_CREATED_SUCCESS_MESSAGE, task, null);

		} catch (Exception ex) {
			return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
					MessageConstant.MessageKey.FAILED_TASK_UNSUCCESS_MESSAGE, null, null);
		}
	}

	/**
	 * userStoryId: ADCPI-382 Summary:BE : Get task Comment: This method is used to
	 * get task for loyalty program
	 * 
	 * @param taskId
	 * @param activeFlag
	 * @return
	 * @throws JsonProcessingException
	 * @throws ParseException
	 */
	@GetMapping(path = UrlConstant.URL.GET_TASK, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getTask(@RequestParam(value = Constant.TASK_ID, required = false) Long taskId,
			@RequestParam(value = Constant.ACTIVE, required = false) Boolean activeFlag)
			throws JsonProcessingException, ParseException {

		List<Task> tasks = null;

		// Validating id should be in digits
//		if (null != taskId) {
//			if (!toolBox.validateIdChecker(taskId))
//				return ResponseMessage.responses(MessageConstant.Status.BAD_REQUEST,
//						MessageConstant.MessageKey.INAVLID_TASK_ID, null, null);
//		}

		tasks = taskService.getTask(taskId, activeFlag);

		return (null != tasks && tasks.size() > 0)
				? ResponseMessage.responses(MessageConstant.Status.SUCCESS_STATUS,
						MessageConstant.MessageKey.FETCH_DATA, tasks, null)
				: ResponseMessage.responses(MessageConstant.Status.DATA_NOT_FOUND_STATUS,
						MessageConstant.MessageKey.DATA_NOT_FOUND, null, 0L);

	}

	@GetMapping(path = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> test(@RequestBody Task task) throws JsonProcessingException, ParseException {
		System.out.println("test");
		return null;
	}

}
