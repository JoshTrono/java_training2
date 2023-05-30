package com.revature.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Product {

    @Id
    @SequenceGenerator(name = "products_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "products_id_seq")
    private Long id;

    private String name;
    private Double price;
}
