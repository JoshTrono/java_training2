package com.revature.TaskManager.controller;


import com.revature.TaskManager.entity.Users;
import com.revature.TaskManager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping
    @Cacheable("users")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }
    @PostMapping("/add")
    @CachePut(value = "users", key="#result.id")
    @CacheEvict(value = "users", allEntries = true)
    public Users saveUser(@RequestParam String username, @RequestParam String password, @RequestParam String email) {
        Users user = new Users();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        return userService.saveUser(user);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDuplicateValueException(DataIntegrityViolationException exception) {
        return new ResponseEntity<>("A user with the same value already exists.", HttpStatus.CONFLICT);
    }

}
