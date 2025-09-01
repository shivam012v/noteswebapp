package com.yash.taskmanager.service;

import com.yash.taskmanager.dto.AddTaskDto;
import com.yash.taskmanager.dto.TaskDto;
import com.yash.taskmanager.entity.Task;
import com.yash.taskmanager.repository.TaskRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepo taskRepo;
    private final ModelMapper modelMapper;

    public TaskServiceImpl(TaskRepo taskRepo, ModelMapper modelMapper) {
        this.taskRepo = taskRepo;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<TaskDto> getTask() {
        List<Task> alltask = taskRepo.findAll();
        return alltask
                .stream()
                .map(task -> modelMapper.map(task, TaskDto.class))
                .toList();
    }

    @Override
    public TaskDto addTask(AddTaskDto addTaskDto) {
        Task newTask = modelMapper.map(addTaskDto, Task.class);
        Task task = taskRepo.save(newTask);

        return modelMapper.map(task, TaskDto.class);
    }

    @Override
    public TaskDto getTaskById(long id) {
        Task task = taskRepo.findById(id).orElse(null);
        return modelMapper.map(task, TaskDto.class);
    }

    @Override
    public boolean deleteTask(long id) {
        if(taskRepo.existsById(id)) {
            taskRepo.deleteById(id);
            return true;
        }
        return false;
    }


}
