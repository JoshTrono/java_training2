package com.revature.ecommerce.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "shoppingCart")
    private List<Product> products;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "shoppingCart")
    private Order order;
}
