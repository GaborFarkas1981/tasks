package com.gfarkas.tasks.dto;

import java.util.List;

public class Task {
    private String taskName;
    private List<String> completedTasksNames;

    public Task() {
    }

    public Task(String taskName, List<String> completedTasksNames) {
        this.taskName = taskName;
        this.completedTasksNames = completedTasksNames;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public List<String> getCompletedTasksNames() {
        completedTasksNames.removeIf(name -> name.equalsIgnoreCase(this.taskName));

        return completedTasksNames;
    }

    public void setCompletedTasksNames(List<String> completedTasksNames) {
        completedTasksNames.removeIf(name -> name.equalsIgnoreCase(this.taskName));
        this.completedTasksNames = completedTasksNames;
    }

}
