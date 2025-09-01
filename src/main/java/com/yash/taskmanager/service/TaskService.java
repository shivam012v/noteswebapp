package com.yash.taskmanager.service;

import com.yash.taskmanager.dto.AddTaskDto;
import com.yash.taskmanager.dto.TaskDto;

import java.util.List;

public interface TaskService {

    public List<TaskDto> getTask();

    TaskDto addTask(AddTaskDto addTaskDto);

    TaskDto getTaskById(long id);

    boolean deleteTask(long id);
}
