package com.revature.Manager.entity;

import jakarta.persistence.*;

@Entity
public class Token {
    @Id
    @SequenceGenerator(name = "tokens_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tokens_id_seq")
    private Long id;

    @Column(nullable = false)
    private String token;


    public Token(String token) {
        this.token = token;
    }

}
