package com.gfarkas.tasks.service;

import com.gfarkas.tasks.api.TasksApiService;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.gfarkas.tasks.TasksDemoApplication.tasks;

@Service
public class TasksApiServiceImpl implements TasksApiService {

    @Override
    public List<String> listAllTasks() {
        return sort(tasks);
    }

    private List<String> sort(Map<String, Set<String>> tasks) {
        Map<String, Set<String>> editableTasks = new HashMap<>(tasks); // copying original tasks
        List<String> sortedList = new ArrayList<>();
        for (Map.Entry<String, Set<String>> entry : tasks.entrySet()) { // iterating through tasks
            String key = entry.getKey();
            Set<String> value = entry.getValue();
            if (value.isEmpty()) {  // get it if it has no dependency
                sortedList.add(key);    // add to the list
                editableTasks.remove(entry.getKey()); // and remove from the input map,
                // so we do not need to check it again
            }
        }
        addTasksToList(editableTasks, sortedList);

        return sortedList;
    }

    private void addTasksToList(Map<String, Set<String>> editableTasks, List<String> sortedList) {
        Map<String, Set<String>> remainingTasks = new HashMap<>(editableTasks); // copying remaining tasks
        for (Map.Entry<String, Set<String>> entry : editableTasks.entrySet()) { // iterating through remaining tasks
            String key = entry.getKey();
            Set<String> value = entry.getValue();
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
