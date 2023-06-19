package com.loyaltyservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loyaltyservice.dao.TaskDao;
import com.loyaltyservice.model.Task;
import com.loyaltyservice.model.TaskParameter;
import com.loyaltyservice.service.TaskService;


@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private TaskDao taskDao;

	@Override
	public void createTask(Task task) {
		taskDao.createTask(task);
		List<Task> newTask = taskDao.getTask(null, true);
		System.out.println("task....."+newTask);
		for(TaskParameter parameter : task.getParameters()) {
			parameter.setTaskId(Long.valueOf(newTask.get(0).getId()));
			taskDao.createTaskParameter(parameter);
		}
	}

	@Override
	public Task getTaskById(Long id) {
		List<Task> tasks = taskDao.getTask(id, null);
		if(null != tasks && !tasks.isEmpty()) {
			Task task = tasks.get(0);
			List<TaskParameter> parameters = taskDao.getTaskParameterByTaskId(task.getId());
			task.setParameters(parameters);
			return tasks.get(0);
		}
		return null;
	}

	@Override
	public List<Task> getActiveTask() {
		List<Task> tasks = taskDao.getTask(null, true);
		for(Task task : tasks) {
			List<TaskParameter> parameters = taskDao.getTaskParameterByTaskId(task.getId());
			task.setParameters(parameters);
		}
		return tasks;
	}

	@Override
	public List<Task> getTask(Long taskId, Boolean activeFlag) {
		List<Task> tasks = taskDao.getTask(taskId, activeFlag);
		for(Task task : tasks) {
			List<TaskParameter> parameters = taskDao.getTaskParameterByTaskId(task.getId());
			task.setParameters(parameters);
		}
		return tasks;
	}

	@Override
	public void updateTask(Task task) {
		taskDao.updateTask(task);
		
	}
}
