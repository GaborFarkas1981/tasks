package com.gfarkas.tasks.dto;

import java.util.Set;

public class Task {
    private String taskName;
    private Set<String> completedTasksNames;

    public Task() {
    }

    public Task(String taskName, Set<String> completedTasksNames) {
        this.taskName = taskName;
        this.completedTasksNames = completedTasksNames;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Set<String> getCompletedTasksNames() {
        completedTasksNames.removeIf(name -> name.equalsIgnoreCase(this.taskName));

        return completedTasksNames;
    }

    public void setCompletedTasksNames(Set<String> completedTasksNames) {
        completedTasksNames.removeIf(name -> name.equalsIgnoreCase(this.taskName));
        this.completedTasksNames = completedTasksNames;
    }

}
