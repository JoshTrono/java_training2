package com.revature.socialMedia.controller;

import com.revature.socialMedia.entity.Post;
import com.revature.socialMedia.entity.User;
import com.revature.socialMedia.service.PostService;
import com.revature.socialMedia.service.TokenService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private final PostService postService;
    @Autowired
    private final TokenService tokenService;


    public PostController(PostService postService, TokenService tokenService) {
        this.postService = postService;
        this.tokenService = tokenService;
    }

    @PostMapping("/create")
    @ResponseBody
    public String createPost(@RequestParam String content, @RequestHeader("Authorization") String token) {
        token = token.split(" ")[1];
        Post post = postService.createPost(content, token);
        return "Post created";
    }

    @GetMapping("/display")
    @ResponseBody
    public String displayPosts(@RequestHeader("Authorization") String token) {
        String token2 = token.split(" ")[1];
        List<Post> posts = postService.displayPosts(token2);
        String display = "";
        // todo fix this to display posts properly
        for (Post post : posts) {
            display += post.getContent() + "\n";
        }
        return display;
    }

}
