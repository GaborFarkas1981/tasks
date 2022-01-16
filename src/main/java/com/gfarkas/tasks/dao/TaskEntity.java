package com.gfarkas.tasks.dao;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node
public class TaskEntity {

    @Id
    @GeneratedValue()
    Long id;
    private String name;
    private String type;
    @Relationship(type = "DEPENDS_ON")
    private List<TaskEntity> deps;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<TaskEntity> getDeps() {
        return deps;
    }

    public void setDeps(List<TaskEntity> deps) {
        this.deps = deps;
    }
}
