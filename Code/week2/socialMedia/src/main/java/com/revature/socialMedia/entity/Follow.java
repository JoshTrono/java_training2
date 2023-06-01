package com.revature.socialMedia.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "follows")
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "follower_id")
    @JsonIgnoreProperties("followees")
    private User follower;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "followee_id")
    @JsonIgnoreProperties("followers")
    private User followee;


}
