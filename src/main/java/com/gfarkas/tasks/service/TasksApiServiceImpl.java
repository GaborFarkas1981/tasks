package com.gfarkas.tasks.service;

import com.gfarkas.tasks.api.TasksApiService;
import com.gfarkas.tasks.dao.TaskEntity;
import com.gfarkas.tasks.dto.TaskDto;
import com.gfarkas.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.gfarkas.tasks.TasksDemoApplication.tasks;

@Service
public class TasksApiServiceImpl implements TasksApiService {

    @Autowired
    TaskRepository repository;

    @Override
    public List<TaskDto> listAllTasks() {
        return sort(tasks);
    }

    private List<TaskDto> sort(Map<String, Map<String, Set<String>>> tasks) {
        Map<String, Map<String, Set<String>>> editableTasks = new HashMap<>(tasks); // copying original tasks
        List<String> sortedList = new ArrayList<>();
        for (Map.Entry<String, Map<String, Set<String>>> entry : tasks.entrySet()) { // iterating through tasks
            String key = entry.getKey();
            Set<String> value = entry.getValue().values().iterator().next();
            if (value.isEmpty()) {  // get it if it has no dependency
                sortedList.add(key);    // add to the list
                editableTasks.remove(entry.getKey()); // and remove from the input map,
                // so we do not need to check it again
            }
        }
        addTasksToList(editableTasks, sortedList);

        List<TaskDto> dtos = new ArrayList<>();
        for (String name : sortedList) {
            TaskDto dto = new TaskDto();
            Map<String, Set<String>> tempMap = tasks.get(name);
            dto.setName(name);
            dto.setType(tempMap.keySet().iterator().next());
            if (!tempMap.values().isEmpty()) {
                dto.setDeps(new HashSet<>());
                for (Set<String> dependencies : tempMap.values()) {
                    for (String dependency : dependencies) {
                        dto.getDeps().add(dependency);
                    }
                }
            }
            dtos.add(dto);
        }

        for (TaskDto dto : dtos) {
            TaskEntity task = new TaskEntity();
            task.setName(dto.getName());
            task.setType(dto.getType());
            if (!dto.getDeps().isEmpty()) {
                task.setDeps(new ArrayList<>());
                for (String dependency : dto.getDeps()) {
                    TaskEntity taskEntity = repository.findByName(dependency);
                    task.getDeps().add(taskEntity);
                }
            }
            repository.save(task);
        }

        return dtos;
    }

    private void addTasksToList(Map<String, Map<String, Set<String>>> editableTasks, List<String> sortedList) {
        Map<String, Map<String, Set<String>>> remainingTasks = new HashMap<>(editableTasks); // copying remaining tasks
        for (Map.Entry<String, Map<String, Set<String>>> entry : editableTasks.entrySet()) { // iterating through remaining tasks
            String key = entry.getKey();
            Set<String> value = entry.getValue().values().iterator().next();
            if (sortedList.containsAll(value)) {    // if sortedlist contains all the dependencies of the actual task
                sortedList.add(key);    // add it to the sortedlist
                remainingTasks.remove(entry.getKey());  // and remove from the remaining map
            }
        }
        while (sortedList.size() < tasks.size()) {  // recursive method call until the sortedlist does not contain all the tasks
            addTasksToList(remainingTasks, sortedList);
        }
    }
}
