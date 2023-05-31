package com.revature.ecommerce.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @SequenceGenerator(name = "products_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "products_id_seq")
    private Long id;

    private String name;

    private String description;
    private Double price;

    private String category;

    @ManyToOne
    private ShoppingCart shoppingCart;

    public Product() {
    }

    public Product(String name, String category, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;

    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


}
