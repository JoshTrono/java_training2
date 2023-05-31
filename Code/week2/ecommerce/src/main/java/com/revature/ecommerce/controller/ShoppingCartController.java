package com.revature.ecommerce.controller;

import com.revature.ecommerce.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shoppingcart")
public class ShoppingCartController {

    @Autowired
    private final ShoppingService shoppingCartService;

    public ShoppingCartController(ShoppingService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

}
