package com.revature.socialMedia.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_seq")
    @SequenceGenerator(name = "post_seq", sequenceName = "post_seq", allocationSize = 1)
    private Long id;

    private String content;

    @ManyToOne
    @JsonBackReference // this is to prevent infinite recursion
    @JoinColumn(name = "user_id")
    private User user;

    public Post(String content, User user) {
        this.content = content;
        this.user = user;
    }

    public Post() {
    }
    public Long getUserId() { // this is to get json to return the user id
        return user.getId();
    }


    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
