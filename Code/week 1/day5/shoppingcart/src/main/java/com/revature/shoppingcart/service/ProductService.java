package com.revature.shoppingcart.service;

import com.revature.shoppingcart.entity.Product;
import com.revature.shoppingcart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }
    public String createProduct(String name, String description, double price, int quantity) {
        Product product = new Product(name, description, price, quantity);
        productRepository.save(product);
        return "Product created";
    }
    public Product getProductbyId(Long id) {
        return productRepository.findById(id).get();
    }
}
