package com.revature.socialMedia.service;

import com.revature.socialMedia.entity.User;
import com.revature.socialMedia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(String username, String password, String email) {
        String encryptedPassword = passwordEncoder.encode(password);
        // Create the user object with the encrypted password
        User user = new User(username, encryptedPassword, email);
        return userRepository.save(user);
    }

    public boolean validatePassword(String username, String rawPassword) {
        User user = userRepository.findByUsername(username);
        String encryptedPassword = user.getPassword();

        return passwordEncoder.matches(rawPassword, encryptedPassword);
    }

    public User loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        String encryptedPassword = user.getPassword();

        if (passwordEncoder.matches(password, encryptedPassword)) {
            return user;
        } else {
            return null;
        }
    }

//    public User registerUser(String username, String password, String email) {
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(password);
//        user.setEmail(email);
//
//        return userRepository.save(user);
//    }


}
