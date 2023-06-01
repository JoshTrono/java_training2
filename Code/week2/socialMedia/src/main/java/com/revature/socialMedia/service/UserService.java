package com.revature.socialMedia.service;

import com.revature.socialMedia.config.GlobalExceptionHandler;
import com.revature.socialMedia.controller.UserController;
import com.revature.socialMedia.entity.Token;
import com.revature.socialMedia.entity.User;
import com.revature.socialMedia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, TokenService tokenService) {
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
        } else if (user == null) {
            throw new GlobalExceptionHandler.CustomException("User not found");
        } else {
            throw new GlobalExceptionHandler.CustomException("User not found or password incorrect");
        }
    }

    public Long logoutUser(String username) {
        User user = userRepository.findByUsername(username);
        Long id = user.getId();
        return id;

    }

    public User getUserByUsername(String decoded) {
        return userRepository.findByUsername(decoded);
    }
}
