package com.revature.social.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String password;

    private String email;

    @OneToMany(mappedBy = "user")
    private List<Post> post;

    @OneToOne(mappedBy = "followee")
    private Follow followee;

    @OneToOne(mappedBy = "follower")
    private Follow follower;
}
