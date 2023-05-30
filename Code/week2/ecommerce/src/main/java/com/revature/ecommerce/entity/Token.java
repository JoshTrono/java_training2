package com.revature.ecommerce.entity;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Token() {
    }
}
