package com.revature.ecommerce.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private List<Product> products;
}
