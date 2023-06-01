package com.revature.socialMedia.repository;

import com.revature.socialMedia.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow, Long> {
}
