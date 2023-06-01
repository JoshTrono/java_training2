package com.revature.socialMedia.service;

import com.revature.socialMedia.repository.UserRepository;
import com.revature.socialMedia.entity.User;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServicetest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private TokenService tokenService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @Test
    public void testRegisterUser() {
        // Set up
        String username = "testuser";
        String password = "testpassword";
        String email = "test@example.com";
        when(userRepository.save(any(User.class))).thenReturn(new User(username, password, email));

        // Execute
        User registeredUser = userService.registerUser(username, password, email);

        // Assert
        // Add your assertions here to verify the expected results
    }
    @Test
    public void login() {
        // Set up
        String username = "username";
        String password = "password";
        User user = new User(username, password, "email");
        when(userRepository.findByUsername(username)).thenReturn(user);
        when(passwordEncoder.matches(password, user.getPassword())).thenReturn(true);

        // Execute
        User loggedInUser = userService.loginUser(username, password);

        // Assert
        assertNotNull(loggedInUser);
        // Assert the response status
        assertEquals(HttpStatus.OK, HttpStatus.OK);
    }

    @Test
    public void testValidatePassword() {
        // Set up
        String username = "testuser";
        String rawPassword = "testpassword";
        User user = new User(username, "encryptedpassword", "test@example.com");
        when(userRepository.findByUsername(username)).thenReturn(user);
        when(passwordEncoder.matches(rawPassword, user.getPassword())).thenReturn(true);

        // Execute
        boolean isValidPassword = userService.validatePassword(username, rawPassword);

        // Assert
        // Add your assertions here to verify the expected results
    }

}
