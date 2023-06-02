package com.revature.socialMedia.repository;

import com.revature.socialMedia.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
    Token findByToken(String token);

    boolean existsByToken(String token);

    void deleteByToken(String token);


    Token findByUser_Id(Long id);
}
