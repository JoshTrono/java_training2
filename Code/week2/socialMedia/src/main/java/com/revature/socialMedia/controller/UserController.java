package com.revature.socialMedia.controller;

import com.revature.socialMedia.entity.User;
import com.revature.socialMedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

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

}
