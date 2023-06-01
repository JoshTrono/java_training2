package com.revature.socialMedia.service;

import com.auth0.jwt.algorithms.Algorithm;
import com.revature.socialMedia.entity.Token;
import com.revature.socialMedia.entity.User;
import com.revature.socialMedia.repository.TokenRepository;
import com.auth0.jwt.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Autowired
    private TokenRepository tokenRepository;


//    @Autowired
//    private JwtBuilder jwtBuilder;


    public TokenService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public Token createToken(User user) {
        String jwt = encodeUserToJwt(user);
        Token token = new Token(jwt, user);
        if (ifTokenExists(token.getToken())) {
            // if I add salt to the token, I want it to delete the prevous token and save the new one
            // need to delete by user id when I do that though
            tokenRepository.delete(tokenRepository.findByToken(token.getToken()));
        } else {
            tokenRepository.save(token);
        }
        return tokenRepository.save(token);
    }

    private boolean ifTokenExists(String token) {
        return tokenRepository.existsByToken(token);
    }

    private String encodeUserToJwt(User user) {

        String jwt = JWT.create()
                .withClaim("username", user.getUsername())
                .withClaim("password", user.getPassword())
                .withClaim("id", user.getId())
                .sign(Algorithm.HMAC256("secret"));
        return jwt;
    }
}
