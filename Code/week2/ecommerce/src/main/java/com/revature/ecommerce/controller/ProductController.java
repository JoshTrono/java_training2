package com.revature.ecommerce.controller;

import com.revature.ecommerce.entity.Product;
import com.revature.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }


    @PostMapping("/add")
    @ResponseBody
    public String addProduct(@RequestParam String name, @RequestParam String category, @RequestParam String description, @RequestParam double price) {
        return productService.addProduct(name, category, description, price);
    }

    @GetMapping("/search")
    public String searchProducts(String category) {
        return productService.searchProducts(category);
    }

}
