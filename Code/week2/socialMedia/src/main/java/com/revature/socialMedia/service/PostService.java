package com.revature.socialMedia.service;

import com.revature.socialMedia.entity.Post;
import com.revature.socialMedia.entity.User;
import com.revature.socialMedia.repository.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class PostService {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private PostRepository postRepository;


    public PostService(TokenService tokenService, PostRepository postRepository) {
        this.tokenService = tokenService;
        this.postRepository = postRepository;
    }

    public Post createPost(String content, String token) {
        User username = tokenService.getUserFromToken(token);
        Post post = postRepository.save(new Post(content, username));
        return post;

    }


    public List<Post> displayPosts(String token) {
        Long id = tokenService.getUserFromToken(token).getId();
        return postRepository.findAll();
    }


}
