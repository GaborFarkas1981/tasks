package com.gfarkas.tasks.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RestController
public class TasksApi {

    @Autowired
    TasksApiService service;

    @GetMapping(value = {"/tasks"})
    public List<String> list() {
        return service.listAllTasks();
    }

}
