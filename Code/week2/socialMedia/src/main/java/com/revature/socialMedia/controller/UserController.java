package com.revature.socialMedia.controller;

import com.revature.socialMedia.config.GlobalExceptionHandler;
import com.revature.socialMedia.entity.Token;
import com.revature.socialMedia.entity.User;
import com.revature.socialMedia.service.TokenService;
import com.revature.socialMedia.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

//    @ExceptionHandler
//    public ResponseEntity<String> handleException(Exception e) {
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//    }
    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/register")
    @ResponseBody
    public User registerUser(@RequestParam String username, @RequestParam String password, @RequestParam String email) {
        return (userService.registerUser(username, password, email));
    }

    @GetMapping("/validate")
    @ResponseBody
    public boolean validatePassword(@RequestParam String username, @RequestParam String rawPassword) {
        // todo actually add some validation and return the token instead of boolean
        return userService.validatePassword(username, rawPassword);
    }

    @GetMapping("/login")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Token loginUser(@RequestParam String username, @RequestParam String password) {
         User user = userService.loginUser(username, password);
         if (user == null) {
             throw new GlobalExceptionHandler.CustomException("User not found or password incorrect");
             //return null;
         } else {
            Token token = tokenService.createToken(user);
            return token;
        }
    }
    @DeleteMapping("/logout")
    @ResponseBody
    public Object logoutUser(@RequestParam String username) {
        Long id = userService.logoutUser(username);

        if (tokenService.existsByUserId(id) == null) {
            return "User is not logged in";
        }
        else {
            tokenService.deleteTokenByUserID(id);
            return "User logged out";
        }
    }


}
