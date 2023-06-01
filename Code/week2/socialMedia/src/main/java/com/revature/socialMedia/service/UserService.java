package com.revature.socialMedia.service;

import com.revature.socialMedia.entity.Token;
import com.revature.socialMedia.entity.User;
import com.revature.socialMedia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
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

    public Object logoutUser(String username) {
        User user = userRepository.findByUsername(username);
        Long id = user.getId();
        if (tokenService.existsByUserId(id) == null) {
            return "User is not logged in";
        }
        else {
            tokenService.deleteTokenByUserID(id);
            return "User logged out";
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
