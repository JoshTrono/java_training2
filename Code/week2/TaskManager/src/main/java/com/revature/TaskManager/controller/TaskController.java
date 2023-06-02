package com.revature.TaskManager.controller;

import com.revature.TaskManager.entity.Task;
import com.revature.TaskManager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TaskController {
    @Autowired
    private final TaskService taskService;

    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
}
