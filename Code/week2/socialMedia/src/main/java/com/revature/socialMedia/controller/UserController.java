package com.revature.socialMedia.controller;

import com.revature.socialMedia.entity.Token;
import com.revature.socialMedia.entity.User;
import com.revature.socialMedia.service.TokenService;
import com.revature.socialMedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

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
    public Token loginUser(@RequestParam String username, @RequestParam String password) {
         User user = userService.loginUser(username, password);
         Token token = tokenService.createToken(user);
         return token;
    }
    @DeleteMapping("/logout")
    @ResponseBody
    public Object logoutUser(@RequestParam String username) {
        return userService.logoutUser(username);
    }

}
