package com.revature.socialMedia.service;

import com.revature.socialMedia.config.GlobalExceptionHandler;
import com.revature.socialMedia.entity.Follow;
import com.revature.socialMedia.entity.User;
import com.revature.socialMedia.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private FollowRepository followRepository;

    @Autowired
    private UserService userService;

    public FollowService(TokenService tokenService, FollowRepository followRepository, UserService userService) {
        this.tokenService = tokenService;
        this.followRepository = followRepository;
        this.userService = userService;
    }

    public void followUser(Long id, String token) {
        User user = tokenService.getUserFromToken(token);
        User user2 = userService.getUserById(id);
        followRepository.save(new Follow(user, user2));
    }

    public List<Follow> getFollowedUsers(Long id) {
        return followRepository.findAllByFollower_Id(id);
    }


//    public List<User> getFollowers(String token) {
//        User user = tokenService.getUserFromToken(token);
//
//    }
}
