package com.revature.ecommerce.repository;

import com.revature.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    User findByUsernameAndPassword(String username, String password); // made a custom query to find by username and password
}
