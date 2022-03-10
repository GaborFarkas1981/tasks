package com.gfarkas.tasks.api;

import com.gfarkas.tasks.dto.SenderResponse;
import com.gfarkas.tasks.dto.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TasksApi {

    @Autowired
    TasksApiService service;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = {"/tasks"})
    public ResponseEntity<List<TaskDto>> list() {
        return new ResponseEntity<>(service.listAllTasks(), HttpStatus.OK);
    }

    @GetMapping(value="/demo")
    public SenderResponse adminEndPoint() {
        return new SenderResponse("Hello From Admin");
    }

    @GetMapping(value="/manager")
    public SenderResponse managerEndPoint() {
        return new SenderResponse("Hello From Manager");
    }

}
