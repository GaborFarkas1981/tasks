package com.gfarkas.tasks.repository;

import com.gfarkas.tasks.dao.TaskEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends Neo4jRepository<TaskEntity, Long> {

    TaskEntity findByName(String name);
}
