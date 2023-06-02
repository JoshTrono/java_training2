package com.revature.socialMedia.repository;

import com.revature.socialMedia.entity.Follow;
import com.revature.socialMedia.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {

    List<Follow> findAllByFollower_Id(Long id);
}
