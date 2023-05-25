package com.revature.SpringData;

import com.revature.SpringData.entity.Post;
import com.revature.SpringData.service.PostService;
import org.hibernate.Hibernate;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class SpringDataApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringDataApplication.class, args);
		//Hibernate.initialize();

		ConfigurableApplicationContext context = SpringApplication.run(SpringDataApplication.class, args);

		PostService postService = context.getBean(PostService.class);

		Optional<Post> post = postService.getPostById(2L);
		post.ifPresent(System.out::println);

		Post newPost = new Post();
		newPost.setTitle("New Post");
		newPost.setContent("This is a new post");

		postService.createPost(newPost);

		post = postService.getPostById(1L);
//		post.ifPresent(System.out::println);
	}


}
