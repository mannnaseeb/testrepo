package com.loyaltyservice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.loyaltyservice.model.Task;
import com.loyaltyservice.model.TaskParameter;



@Mapper
public interface TaskDao {
	/**
	 * 
	 */
	public Long createTask(Task task);
	/**
	 * 
	 */
	public void createTaskParameter(TaskParameter parameter);
	/**
	 * 
	 * @param taskId
	 * @return
	 */
	public List<TaskParameter> getTaskParameterByTaskId(@Param("taskId") Long taskId);
	/**
	 * 
	 * @param id
	 * @param object
	 * @return
	 */
	public List<Task> getTask(@Param("taskId") Long taskId, @Param("activeFlag") Boolean activeFlag);
	/**
	 * 
	 * @param task
	 */
	public void updateTask(Task task);
	
}
