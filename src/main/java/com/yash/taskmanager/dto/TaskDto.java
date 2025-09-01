package com.yash.taskmanager.dto;

public class TaskDto {

    private long id;
    private String name;
    private String description;
    private boolean completed;

    public TaskDto(long id, String name, String description, boolean completed) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.completed = completed;
    }

    public TaskDto() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
