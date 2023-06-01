package com.revature.socialMedia.controller;

import com.revature.socialMedia.entity.User;
import com.revature.socialMedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
