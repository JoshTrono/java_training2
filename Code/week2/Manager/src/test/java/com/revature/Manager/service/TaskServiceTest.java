package com.revature.Manager.service;

import com.revature.Manager.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class TaskServiceTest {

    @MockBean
    TaskRepository taskRepository;

    @Autowired
    TaskService taskService;

    @Test
    public void testCreateTask() {

    }

    @Test
    public void testGetAllTasks() {

    }

    @Test
    public void testGetTaskById() {

    }

    @Test
    public void testGetTaskByUser() {

    }

    @Test
    public void testUpdateTask() {

    }

    @Test
    public void testDeleteTask() {

    }
}
