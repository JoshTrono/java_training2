package com.revature.Manager.repository;

import com.revature.Manager.entity.User;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    User findByUsernameAndPassword(String username, String password); // made a custom query to find by username and password
}
