package com.revature.socialMedia.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;

@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    private Long id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String email;

    @OneToMany(mappedBy = "user")
    @Size(min = 0)
    private List<Post> post;

//    @OneToOne(mappedBy = "followee", fetch = FetchType.LAZY)
//    private Follow followee;
//
//    @OneToOne(mappedBy = "follower", fetch = FetchType.LAZY)
//    private Follow follower;

    public User() {
    }

    public User(@NotNull(message = "Username cannot be null") String username, @NotNull(message = "Password cannot be null") String password, @NotNull(message = "Email cannot be null") String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User(@NotNull(message = "Username cannot be null") String username, @NotNull(message = "Password cannot be null") String password, @NotNull(message = "Email cannot be null") String email, List<Post> post) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.post = post;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", post=" + post +
//                ", followee=" + followee +
//                ", follower=" + follower +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }



//    public Follow getFollowee() {
//        return followee;
//    }
//
//    public void setFollowee(Follow followee) {
//        this.followee = followee;
//    }
//
//    public Follow getFollower() {
//        return follower;
//    }
//
//    public void setFollower(Follow follower) {
//        this.follower = follower;
//    }

}
