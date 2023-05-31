package com.revature.ecommerce.service;

import com.revature.ecommerce.entity.Product;
import com.revature.ecommerce.repository.ProductRepository;
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

    public String searchProducts(String category) {
        productRepository.findByCategory(category);
        return "searching products";
    }

    public String addProduct(String name, String category, String description, double price) {
        productRepository.save(new Product(name, category, description, price) );
        return "adding product";
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();

    }
}
