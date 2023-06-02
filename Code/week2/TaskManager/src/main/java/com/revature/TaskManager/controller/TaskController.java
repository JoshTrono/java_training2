package com.revature.TaskManager.controller;

import com.revature.TaskManager.entity.Task;
import com.revature.TaskManager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private final TaskService taskService;
    @Autowired
    private CacheManager cacheManager;
    @GetMapping
    @Cacheable(value = "tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
    @PostMapping("/save")
    @CacheEvict(value = "tasks", allEntries = true)
    @CachePut(value = "tasks", key="#result.id")
    public Task saveTask(@RequestParam String description, @RequestParam String status) {
        Task task = new Task();
        task.setDescription(description);
        task.setStatus(status);
        return taskService.saveTask(task);
    }

}
