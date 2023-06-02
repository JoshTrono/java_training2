package com.revature.socialMedia.controller;

import com.revature.socialMedia.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/follow")
public class FollowController {

    @Autowired
    FollowService followService;

    @PostMapping("/{id}")
    @ResponseBody
    public String followUser(@RequestParam Long id, @RequestHeader("Authorization") String token) {
        String token2 = token.split(" ")[1];
        followService.followUser(id, token2);
        return "User followed";
    }
}
