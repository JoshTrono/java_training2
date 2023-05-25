package com.revature.SpringData.respository;

import com.revature.SpringData.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    // Custom query methods can be added here if needed
}