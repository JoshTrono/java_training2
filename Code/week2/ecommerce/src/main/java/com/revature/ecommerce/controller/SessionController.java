package com.revature.ecommerce.controller;

import com.revature.ecommerce.entity.User;
import com.revature.ecommerce.repository.UserRepository;
import com.revature.ecommerce.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class SessionController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestParam String username, @RequestParam String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if ( user != null) {
            return authenticationService.login(username, password, user.getId(), user.getRole());
        } else {
            return "login failed";
        }
    }

    @GetMapping("/auth")
    @ResponseBody
    public String validateToken(@RequestParam String token) {
        return authenticationService.validateToken(token);
    }

    @PostMapping("/register")
    @ResponseBody
    public String register(@RequestParam String username, @RequestParam String password, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String role) {
        userRepository.save(new User(username, password, firstName, lastName, role));
        return "registered";
    }
}
