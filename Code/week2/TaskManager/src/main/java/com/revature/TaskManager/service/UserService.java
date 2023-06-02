package com.revature.TaskManager.service;

import com.revature.TaskManager.config.GlobalExceptionHandler;
import com.revature.TaskManager.entity.Users;
import lombok.RequiredArgsConstructor;
import com.revature.TaskManager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    @Cacheable("users")
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }
    public Users saveUser(Users user) {
        return userRepository.save(user);
    }
    public Users getUserByTokenLong (String token) {
        return (Users) userRepository.findByToken(token).orElseThrow(() -> new GlobalExceptionHandler.CustomException("User not found"));
    }

    public Users getUserByUsername(String assignTo) {
        return (Users) userRepository.findByUsername(assignTo).orElseThrow(() -> new GlobalExceptionHandler.CustomException("User not found"));
    }
}
