package com.revature.shoppingcart.controller;


import com.revature.shoppingcart.entity.Cart;
import com.revature.shoppingcart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;
    @GetMapping("/")
    @ResponseBody
    public List<Cart> getAllCarts() {
        return cartService.getCarts();
    }
    @PostMapping("/create")
    @ResponseBody
    public String createCart(@RequestParam String description) {
        return cartService.createCart(description);
    }
    @PostMapping("/addProduct")
    @ResponseBody
    public String addProductToCart(@RequestParam Long productId, @RequestParam Long cartId) {
        return cartService.addProductToCart(productId, cartId);
    }
}
