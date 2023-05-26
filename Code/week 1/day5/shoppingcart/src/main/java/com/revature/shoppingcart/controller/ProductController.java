package com.revature.shoppingcart.controller;

import com.revature.shoppingcart.entity.Product;
import com.revature.shoppingcart.repository.ProductRepository;
import com.revature.shoppingcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    @ResponseBody
    public List<Product> getProducts() {
        return productService.getProducts();
    }
    @PostMapping("/create")
    @ResponseBody
    public String createProduct(String name, String description, double price, int quantity) {
        return productService.createProduct(name, description, price, quantity);
    }
}
