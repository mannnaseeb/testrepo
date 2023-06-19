package com.loyaltyservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.loyaltyservice.constant.Constant;
import com.loyaltyservice.model.Customer;
import com.loyaltyservice.model.Event;
import com.loyaltyservice.model.Task;
import com.loyaltyservice.model.TaskParameter;
import com.loyaltyservice.model.TaskStatus;
import com.loyaltyservice.model.Transaction;
import com.loyaltyservice.service.EventService;
import com.loyaltyservice.service.TaskService;
import com.loyaltyservice.service.TransactionService;

@Component
public class LoyaltyTaskHandler {

	@Autowired
	private TaskService taskService;

	@Autowired
	private EventService eventService;

	@Autowired
	private TransactionService transactionService;

	@Scheduled(cron = "${loyalty.process.schedule}")
	//@Scheduled(cron = "-")
	public void handleTask() {
		List<Task> tasks = taskService.getActiveTask();
		if (!tasks.isEmpty()) {
			for (Task task : tasks) {
				task.setIsActive(true);
				task.setTaskStatus(null);
				// taskService.updateTask(task);
				processLoyalty(task);
				task.setIsActive(false);
				TaskStatus status = new TaskStatus();
				status.setId(2L);
				task.setTaskStatus(status);
				taskService.updateTask(task);
			}
		} else {
			System.out.println("no task available for processing...");
		}
	}

	public void processLoyalty(Task task) {
		Task activeTask = taskService.getTaskById(task.getId());
		Event event = null;
		Long customerId = null;
		String eventType = null;
		for (TaskParameter parameter : activeTask.getParameters()) {
			if (parameter.getParameterName().equals(Constant.EVENT_ID)) {
				List<Event> events = eventService.getEvent(Long.parseLong(parameter.getParameterValue()), null, null,
						null, null, null, null, null);
				if (null != events && !events.isEmpty()) {
					event = events.get(0);
				}
			} else if (parameter.getParameterName().equals(Constant.PARTNER_ID)) {
				customerId = Long.parseLong(parameter.getParameterValue());
			} else if (parameter.getParameterName().equals(Constant.EVENT_TYPE)) {
				eventType = parameter.getParameterValue();
			}
		}
		if (null != event) {
			Customer customer = new Customer();
			customer.setCustomerId(customerId);
			Transaction transaction = new Transaction();
			transaction.setCustomer(customer);
			transaction.setEvent(event);
			transaction.setEventType(event.getEvetType());
			transaction.setPoint(Long.valueOf(event.getRule().getRuleCalc()));
			transactionService.createTransaction(transaction);
		}

	}

}
