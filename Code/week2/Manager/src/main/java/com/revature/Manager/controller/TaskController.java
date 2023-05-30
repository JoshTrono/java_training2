package com.revature.Manager.controller;


import com.revature.Manager.entity.Task;
import com.revature.Manager.service.AuthenticationService;
import com.revature.Manager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    AuthenticationService authenticationService;


    @PostMapping("/create")
    @ResponseBody
    public String createTask(@RequestParam String taskName, @RequestParam String description, @RequestParam String duedate, @RequestParam String status, @RequestHeader("Authorization") String jwt) {
        String tokenString = authenticationService.validateToken(jwt.split(" ")[1].trim());
        if (tokenString.split(" ")[0].equals("valid")) {
            taskService.createTask(taskName, description, duedate, status, Long.parseLong(tokenString.split(" ")[3].trim()));
            return "task created";
        } else {
            return "invalid token";
        }
    }
    @GetMapping("/display")
    @ResponseBody
    public List<Task> displayTask(@RequestHeader("Authorization") String jwt) {
        String tokenString = authenticationService.validateToken(jwt.split(" ")[1].trim());
        if (tokenString.split(" ")[0].equals("valid")) {
            return taskService.displayTask(Long.parseLong(tokenString.split(" ")[3].trim()));
            //taskService.createTask(taskName, taskDescription, taskStatus, DueDate, AssignedTo);

        } else {
            return null;
        }
    }



}
