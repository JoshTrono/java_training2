package com.revature.socialMedia.service;

import com.revature.socialMedia.config.GlobalExceptionHandler;
import com.revature.socialMedia.entity.Follow;
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

    @Autowired
    private FollowService followService;


    public PostService(TokenService tokenService, PostRepository postRepository, FollowService followService) {
        this.tokenService = tokenService;
        this.postRepository = postRepository;
        this.followService = followService;
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


    public List<Post> displayPostsByUserId(Long id, String token) {
        String token2 = token.split(" ")[1];
        User user = tokenService.getUserFromToken(token2);
        if (user.getId() != id) {
            throw new GlobalExceptionHandler.CustomException("You are not authorized to view this user's posts");
        }
        return postRepository.findAllByUser_Id(id);
    }

    public void deletePost(Long id, String token) {
        String token2 = token.split(" ")[1];
        User user = tokenService.getUserFromToken(token2);
        Post post = postRepository.findById(id).orElseThrow(() -> new GlobalExceptionHandler.CustomException("Post not found"));
        if (user.getId() != post.getUser().getId()) {
            throw new GlobalExceptionHandler.CustomException("You are not authorized to delete this post");
        }
        postRepository.deleteById(id);
    }

    public List<Post> displayPostsByFollowedUsers(String token) {

        User user = tokenService.getUserFromToken(token);
        List<Post> posts = new ArrayList<>();
        List<Follow> users = followService.getFollowedUsers(user.getId());
        for (Follow follow : users) {
            posts.addAll(postRepository.findAllByUser_Id(follow.getFollowed().getId()));
        }
        return posts;
    }
}
