package com.revature.socialMedia.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
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



    public PostController(PostService postService) {
        this.postService = postService;

    }

    @PostMapping("/create")
    @ResponseBody
    public String createPost(@RequestParam String content, @RequestHeader("Authorization") String token) {
        token = token.split(" ")[1];
        Post post = postService.createPost(content, token);
        return "Post created";
    }

    @GetMapping(value = "/display", produces = "application/json")
    @ResponseBody
    public List<Post> displayPosts(@RequestHeader("Authorization") String token) {
        String token2 = token.split(" ")[1];
        List<Post> posts = postService.displayPosts(token2);
//        List<Post> post2 = new ArrayList<>();
//        for (Post post : posts) {
//            post2.add(post);
//        }
//        JsonCreator.Mode mode = JsonCreator.Mode.DELEGATING;
//        mode.name();
        return posts;
    }

    @GetMapping(value = "/display/{id}")
    @ResponseBody
    public List<Post> displayPostsByUserId(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        List<Post> posts = postService.displayPostsByUserId(id, token);
        return posts;
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String deletePost(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        token = token.split(" ")[1];
        postService.deletePost(id, token);
        return "Post deleted";
    }

    @GetMapping("/follow")
    @ResponseBody
    public List<Post> displayPostsByFollowedUsers(@RequestHeader("Authorization") String token) throws ExecutionException, InterruptedException {
        token = token.split(" ")[1];
        List<Post> posts = postService.displayPostsByFollowedUsers(token);
        return posts;
    }

}
