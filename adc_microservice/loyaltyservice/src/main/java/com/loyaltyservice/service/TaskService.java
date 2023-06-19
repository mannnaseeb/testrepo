package com.loyaltyservice.service;

import java.util.List;

import com.loyaltyservice.model.Task;

public interface TaskService {
	/**
	 * 
	 */
	public void createTask(Task task);
	/**
	 * 
	 * @return
	 */
	public Task getTaskById(Long id);
	/**
	 * 
	 * @return
	 */
	public List<Task> getActiveTask();
	/**
	 * 
	 * @param taskId
	 * @param activeFlag
	 * @return
	 */
	public List<Task> getTask(Long taskId, Boolean activeFlag);
	/**
	 * 
	 * @param task
	 */
	public void updateTask(Task task);
}
