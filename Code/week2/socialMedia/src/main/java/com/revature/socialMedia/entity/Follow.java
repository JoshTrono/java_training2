package com.revature.socialMedia.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "follows")
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "follow_seq")
    @SequenceGenerator(name = "follow_seq", sequenceName = "follow_seq", allocationSize = 1)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "follower_id")
    @JsonIgnoreProperties("followees")
    private User follower;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "followee_id")
    @JsonIgnoreProperties("followers")
    private User followee;

    public Follow() {
    }

    public Follow(User follower, User followee) {
        this.follower = follower;
        this.followee = followee;
    }

    @Override
    public String toString() {
        return "Follow{" +
                "id=" + id +
                ", follower=" + follower +
                ", followee=" + followee +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }

    public User getFollowee() {
        return followee;
    }

    public void setFollowee(User followee) {
        this.followee = followee;
    }

    public Follow getFollowed() {
        return this;
    }
}
