package com.revature.ecommerce.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.revature.ecommerce.entity.Token;
import com.revature.ecommerce.entity.User;
import com.revature.ecommerce.repository.TokenRepository;
import com.revature.ecommerce.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class AuthenticationServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private TokenRepository tokenRepository;

    private AuthenticationService authenticationService;

    private final String secretString = "secret";

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        authenticationService = new AuthenticationService(userRepository, tokenRepository);
    }

    @Test
    public void testLogin_ValidCredentials_ReturnsJwtToken() {
        // Arrange
        String username = "testUser";
        String password = "password";
        Long id = 1L;
        String role = "USER";

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        when(userRepository.findByUsernameAndPassword(username, password)).thenReturn(user);

        // Act
        String jwtToken = authenticationService.login(username, password, id, role);
        Algorithm algorithm = Algorithm.HMAC512("secret");
        String jwt = JWT.create()
                .withClaim("username", username)
                .withClaim("password", password)
                .withClaim("id", id)
                .withClaim("role", role)
                .sign(algorithm);

        // Assert
        assertEquals(jwt, jwtToken);
    }

    @Test
    public void testLogin_InvalidCredentials_ReturnsLoginFailed() {
        // Arrange
        String username = "testUser";
        String password = "incorrectPassword";

        when(userRepository.findByUsernameAndPassword(username, password)).thenReturn(null);

        // Act
        String result = authenticationService.login(username, password, null, null);

        // Assert
        assertEquals("login failed", result);
    }

    // Add more tests for other methods in the AuthenticationService class

}
