package com.revature.Manager.service;

import com.revature.Manager.entity.User;
import com.revature.Manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String login() {
        return "login";
    }
    public String register (String username, String password, String email, String firstName, String lastName, String role) {
        userRepository.save(new User(username, password, firstName, lastName, role));
        return "registered";
    }

    // made a custom query to find by username and password
    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
