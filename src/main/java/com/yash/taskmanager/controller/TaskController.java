package com.yash.taskmanager.controller;

import com.yash.taskmanager.dto.TaskDto;
import com.yash.taskmanager.dto.AddTaskDto;
import com.yash.taskmanager.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    private final TaskService taskService;

    @GetMapping("/")
    public ResponseEntity<List<TaskDto>> getTask() {
        return ResponseEntity.ok().body(taskService.getTask());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable int id) {
        return ResponseEntity.ok().body(taskService.getTaskById(id));
    }

    @PostMapping("/")
    public ResponseEntity<TaskDto> addTask(@RequestBody AddTaskDto addTaskDto) {
        return ResponseEntity.ok().body(taskService.addTask(addTaskDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TaskDto> deleteTask(@PathVariable long id) {
        if(taskService.deleteTask(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable long id, @RequestBody AddTaskDto addTaskDto) {
        return ResponseEntity.ok().body(taskService.updateTask(id, addTaskDto));
    }

}
