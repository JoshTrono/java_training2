package com.revature.TaskManager.service;

import com.revature.TaskManager.config.GlobalExceptionHandler;
import com.revature.TaskManager.entity.Task;
import com.revature.TaskManager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    @Autowired
    private final TaskRepository taskRepository;
    @Autowired
    private final UserService userService;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new GlobalExceptionHandler.CustomException("Task not found"));
    }

    public List<Task> getMyTasks(String token) {
        //userService.getUserByTokenLong(token);
        return taskRepository.findAllByAssignedTo(userService.getUserByTokenLong(token));

    }

    public Task assignTask(Long taskId, String assignTo) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new GlobalExceptionHandler.CustomException("Task not found"));
        task.setAssignedTo(userService.getUserByUsername(assignTo));
        return taskRepository.save(task);
    }
}
