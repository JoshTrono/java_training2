package com.revature.socialMedia.repository;

import com.revature.socialMedia.entity.Post;
import com.revature.socialMedia.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {


    List<Post> findAllByUser_Id(Long id);
}
