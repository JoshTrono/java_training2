package com.revature.Manager.service;

import com.revature.Manager.entity.Token;
import com.revature.Manager.entity.User;
import com.revature.Manager.repository.TokenRepository;
import com.revature.Manager.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AuthenticationServiceTest {
    @MockBean
    UserRepository userRepository;

    @MockBean
    TokenRepository tokenRepository;

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationService authenticationService;



    @Test
    public void testLogin() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("test");

        when(userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword())).thenReturn(user);
        User foundUser = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        assert(foundUser.getUsername().equals(user.getUsername()));
        assertEquals(foundUser.getUsername(), user.getUsername());
    }
    @Test
    public void failTestLogin() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("test");

        when(userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword())).thenReturn(user);
        User foundUser = userService.findByUsernameAndPassword("fail", "fail");
        assert(foundUser == null);
    }
    // make a unit test for validateToken method
    // make a unit test for logout method
    @Test
    public void testLogout() {
        assertEquals(authenticationService.logout(), "logout");
    }

    // make a unit test for register method
    @Test
    public void testRegister() {
        assertEquals(authenticationService.register("test", "test", "test", "test", "test", "test"), "register");
    }
}
