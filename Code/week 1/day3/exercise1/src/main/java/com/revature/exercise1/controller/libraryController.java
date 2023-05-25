package com.revature.exercise1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class libraryController {

    @GetMapping("/hi")
    public String SayHello() {
        return "Hello";
    }
}
