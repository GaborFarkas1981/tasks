package com.gfarkas.tasks;

import com.gfarkas.tasks.service.TasksApiServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
public class TasksDemoApplication {

    public static Map<String, Set<String>> tasks;

    public static void main(String[] args) {
        SpringApplication.run(TasksDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(TasksApiServiceImpl service) {
        return args -> {
            tasks = new HashMap<>();
            tasks.put("fix bug 1", new HashSet<>());
            tasks.put("fix bug 2", new HashSet<>());
            tasks.put("refactor W", new HashSet<>());
            tasks.put("implement feature X", new HashSet<>(Arrays.asList("fix bug 2", "refactor W")));
            tasks.put("release", new HashSet<>(Arrays.asList("fix bug 1", "fix bug 2", "implement feature X")));
            tasks.put("deploy", new HashSet<>(List.of("release")));

            service.listAllTasks();
        };
    }
}
