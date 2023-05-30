package com.revature.Manager.service;

import com.revature.Manager.entity.Task;
import com.revature.Manager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {


    @Autowired
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public void createTask(@RequestParam String taskName, @RequestParam String description, String dueDate, String Status, Long user_id) {
        taskRepository.save(new Task(taskName, description, dueDate, Status, user_id));
    }
    public List<Task> displayTask(Long user_id) {

        return taskRepository.findByUserId(user_id);
    }

}
