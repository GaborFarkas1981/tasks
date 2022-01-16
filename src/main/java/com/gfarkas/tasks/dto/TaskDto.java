package com.gfarkas.tasks.dto;

import java.util.Set;

public class TaskDto {
    private String name;
    private Set<String> deps;
    private String type;

    public TaskDto() {
    }

    public TaskDto(String name, Set<String> deps, String type) {
        this.name = name;
        this.deps = deps;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getDeps() {
        deps.removeIf(name -> name.equalsIgnoreCase(this.name));

        return deps;
    }

    public void setDeps(Set<String> deps) {
        deps.removeIf(name -> name.equalsIgnoreCase(this.name));
        this.deps = deps;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
