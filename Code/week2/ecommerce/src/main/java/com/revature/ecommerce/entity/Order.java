package com.revature.ecommerce.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(generator = "order_id_seq")
    private Long orderId;


    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


    @OneToOne
    @JoinColumn(name = "shoppingCart_id")
    private ShoppingCart shoppingCart;


}
