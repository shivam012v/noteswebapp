package com.yash.taskmanager.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddTaskDto {

    private String name;
    private String description;
    private boolean completed;

    public AddTaskDto() {
    }

    public AddTaskDto(String name, String description, boolean completed) {
        this.name = name;
        this.description = description;
        this.completed = completed;
    }
}
