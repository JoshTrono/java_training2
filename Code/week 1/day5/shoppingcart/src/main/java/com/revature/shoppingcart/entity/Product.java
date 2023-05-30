package com.revature.shoppingcart.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "products")
public class Product {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String product;
        private String description;
        private Double price;
        private Integer quantity;


        @OneToMany(mappedBy = "products")
        private List<Cart> carts;

        public Product() {
        }

        public Product(String product, String description, Double price, Integer quantity) {

                this.product = product;
                this.description = description;
                this.price = price;
                this.quantity = quantity;
        }

        @Override
        public String toString() {
                return "Product{" +
                        "id=" + id +
                        ", product='" + product + '\'' +
                        ", description='" + description + '\'' +
                        ", price=" + price +
                        ", quantity=" + quantity +
                        ", carts=" + carts +
                        '}';
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getProduct() {
                return product;
        }

        public void setProduct(String product) {
                this.product = product;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public Double getPrice() {
                return price;
        }

        public void setPrice(Double price) {
                this.price = price;
        }

        public Integer getQuantity() {
                return quantity;
        }

        public void setQuantity(Integer quantity) {
                this.quantity = quantity;
        }

        public List<Cart> getCarts() {
                return carts;
        }

        public void setCarts(List<Cart> carts) {
                this.carts = carts;
        }
}
