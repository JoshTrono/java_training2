package com.revature.ecommerce.controller;

import com.revature.ecommerce.entity.User;
import com.revature.ecommerce.service.AuthenticationService;
import com.revature.ecommerce.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/shoppingcart")
public class ShoppingCartController {


    @Autowired
    private final AuthenticationService authenticationService;
    @Autowired
    private final ShoppingService shoppingCartService;

    public ShoppingCartController(ShoppingService shoppingCartService, AuthenticationService authenticationService) {
        this.shoppingCartService = shoppingCartService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/create")
    @ResponseBody
    public int createShoppingCart(@RequestHeader("Authorization") String token) {
        if (authenticationService.validateToken(token).equals("invalid")) {
            return -1;
        } else {
            Long id2 = authenticationService.getUserId(token.split(" ")[1]);
            User user = authenticationService.getUserbyId(id2);
            int id = Integer.parseInt(shoppingCartService.createShoppingCart(user).getId().toString());
            return id;
        }

    }

    @PostMapping("/add")
    public String addProductToCart(@RequestParam Long productId, @RequestParam Long shoppingCartId) {
        return shoppingCartService.addProductToCart(productId, shoppingCartId);
    }
}
