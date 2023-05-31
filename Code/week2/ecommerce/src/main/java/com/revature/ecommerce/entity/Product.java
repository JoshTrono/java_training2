package com.revature.ecommerce.entity;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @SequenceGenerator(name = "products_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "products_id_seq")
    private Long id;

    private String name;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shoppingCart;



}
