package com.gfarkas.tasks.service;

import com.gfarkas.tasks.api.TasksApiService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class TasksApiServiceImpl implements TasksApiService {

    @Override
    public List<String> listAllTasks() {
        return null;
    }

    private List<String> sort(Map<String, Set<String>> tasks) {
        return null;
    }
}
