package com.revature.shoppingcart.service;

import com.revature.shoppingcart.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.shoppingcart.repository.CartRepository;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private final CartRepository cartRepository;
    @Autowired
    private final ProductService productService;

    public CartService(CartRepository cartRepository , ProductService productService) {
        this.cartRepository = cartRepository;
        this.productService = productService;
    }

    public String createCart(String description) {
        Cart cart = new Cart(description);
        cartRepository.save(cart);
        return "Cart created";
    }
    public List<Cart> getCarts() {
        return cartRepository.findAll();
    }
    public String addProductToCart(Long productId, Long cartId) {
        Cart cart = cartRepository.findById(cartId).get();

        cart.getProducts().add(productService.getProductbyId(productId));
        cartRepository.save(cart);
        return "Product added to cart";
    }

}
