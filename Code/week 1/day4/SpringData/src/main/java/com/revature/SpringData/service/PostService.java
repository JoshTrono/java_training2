package com.revature.SpringData.service;

import com.revature.SpringData.entity.Post;
import com.revature.SpringData.respository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post createPost(Post post) {
        // TODO: Implement the logic to save a new blog post
        return postRepository.save(post);
    }

    public Optional<Post> getPostById(Long id) {
        // TODO: Implement the logic to retrieve a blog post by its ID
        return postRepository.findById(id);
    }

    public List<Post> getAllPosts() {
        // TODO: Implement the logic to retrieve all blog posts
        return postRepository.findAll();
    }

    public Post updatePost(Post post) {
        // TODO: Implement the logic to update an existing blog post
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        // TODO: Implement the logic to delete a blog post by its ID
        postRepository.deleteById(id);
    }
}
