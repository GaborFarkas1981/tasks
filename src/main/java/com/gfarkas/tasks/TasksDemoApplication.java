package com.gfarkas.tasks;

import com.gfarkas.tasks.service.TasksApiServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
public class TasksDemoApplication {

    public static Map<String, Map<String, Set<String>>> tasks; // name, type, dependencies

    public static void main(String[] args) {
        SpringApplication.run(TasksDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(TasksApiServiceImpl service) {
        return args -> {
            tasks = new HashMap<>();
            Map<String, Set<String>> bugMap = new HashMap<>();
            bugMap.put("BUG", new HashSet<>());
            tasks.put("fix bug 1", bugMap);
            tasks.put("fix bug 2", bugMap);
            Map<String, Set<String>> refactorMap = new HashMap<>();
            refactorMap.put("IMPR", new HashSet<>());
            tasks.put("refactor W", refactorMap);
            Map<String, Set<String>> implementMap = new HashMap<>();
            implementMap.put("IMPL", new HashSet<>(Arrays.asList("fix bug 2", "refactor W")));
            tasks.put("implement feature X", implementMap);
            Map<String, Set<String>> infra1Map = new HashMap<>();
            infra1Map.put("INFRA", new HashSet<>(Arrays.asList("fix bug 1", "fix bug 2", "implement feature X")));
            tasks.put("release", infra1Map);
            Map<String, Set<String>> infra2Map = new HashMap<>();
            infra2Map.put("INFRA", new HashSet<>(List.of("release")));
            tasks.put("deploy", infra2Map);

            service.listAllTasks();
        };
    }
}
