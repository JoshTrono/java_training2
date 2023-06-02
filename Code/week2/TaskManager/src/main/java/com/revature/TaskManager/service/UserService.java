package com.revature.TaskManager.service;

import com.revature.TaskManager.entity.Users;
import lombok.RequiredArgsConstructor;
import com.revature.TaskManager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }
    public Users saveUser(Users user) {
        return userRepository.save(user);
    }
}
