package com.revature.TaskManager.repository;

import com.revature.TaskManager.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Object> findByToken(String token);

    Optional<Object> findByUsername(String assignTo);
}
