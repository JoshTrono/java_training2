package com.revature.Manager.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.revature.Manager.entity.Token;
import com.revature.Manager.repository.TaskRepository;
import com.revature.Manager.repository.TokenRepository;
import com.revature.Manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticationService {

    private String secretString = "secret";
    Algorithm algorithm = Algorithm.HMAC512(secretString);

    //@Autowired
    //private final UserRepository userRepository;

    @Autowired
    private final TokenRepository tokenRepository;

    public AuthenticationService(UserRepository userRepository, TokenRepository tokenRepository) {
        //this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
    }

        public String login(String username, String password, Long id, String role) {
            String jwt = JWT.create()
                    .withClaim("username", username)
                    .withClaim("password", password)
                    .withClaim("id", id)
                    .withClaim("role", role)
                    .sign(algorithm);

            tokenRepository.save(new Token(jwt));
            return jwt;
        }

        public String logout() {
            return "logout";
        }

        public String register(String username, String password, String email, String firstName, String lastName, String role) {
            return "register";
        }


}
