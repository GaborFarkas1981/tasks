package com.gfarkas.tasks.api;

import com.gfarkas.tasks.dto.TaskDto;
import java.util.List;

public interface TasksApiService {
    List<TaskDto> listAllTasks();
}
