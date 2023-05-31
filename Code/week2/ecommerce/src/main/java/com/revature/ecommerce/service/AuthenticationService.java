package com.revature.ecommerce.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.revature.ecommerce.entity.Token;
import com.revature.ecommerce.entity.User;
import com.revature.ecommerce.repository.TokenRepository;
import com.revature.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticationService {

    private String secretString = "secret";
    Algorithm algorithm = Algorithm.HMAC512(secretString);

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final TokenRepository tokenRepository;

    public AuthenticationService(UserRepository userRepository, TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
    }

        public String login(String username, String password, Long id, String role) {
            User user = userRepository.findByUsernameAndPassword(username, password);
            if (user != null) {
                String jwt = JWT.create()
                        .withClaim("username", username)
                        .withClaim("password", password)
                        .withClaim("id", id)
                        .withClaim("role", role)
                        .sign(algorithm);

                tokenRepository.save(new Token(jwt, user));
                return jwt;

            }
            return "login failed";
        }

        public User getUserbyId(Long id) {
            return userRepository.findById(id).get();
        }

        public String logout() {
            return "logout";
        }

        public String register(String username, String password, String email, String firstName, String lastName, String role) {
            return "register";
        }

        public String validateToken(String token2) {
            String token = token2.split(" ")[1];
            List<Token> tokens = new ArrayList<>();
            tokenRepository.findAll().forEach(tokens::add);
            for (Token t : tokens) {
                if (t.getToken().equals(token)) {
                    DecodedJWT jwt = decode(token);


                    return String.format("valid");
                }
            }
            return "invalid";
        }
        public Long getUserId(String token) {
            DecodedJWT jwt = decode(token);
            return jwt.getClaim("id").asLong();
        }


        private DecodedJWT decode(String token) {
            return JWT.require(algorithm).build().verify(token);
        }
}
