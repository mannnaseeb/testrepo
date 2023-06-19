package com.loyaltyservice.model;

import java.util.Date;
import java.util.List;

public class Task {
	private Long id;
	private String createdBy;
	private Date createdOn;
	private Boolean isActive;
	private TaskType taskType;
	private TaskStatus taskStatus;
	private List<TaskParameter> parameters;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public TaskType getTaskType() {
		return taskType;
	}
	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}
	public TaskStatus getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}
	public List<TaskParameter> getParameters() {
		return parameters;
	}
	public void setParameters(List<TaskParameter> parameters) {
		this.parameters = parameters;
	}
	
	
}
