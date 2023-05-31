package com.revature.ecommerce.service;

import com.revature.ecommerce.entity.Product;
import com.revature.ecommerce.entity.ShoppingCart;
import com.revature.ecommerce.entity.User;
import com.revature.ecommerce.repository.ProductRepository;
import com.revature.ecommerce.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingService {
    @Autowired
    private final OrderService orderService;
    @Autowired
    private final ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private final ProductRepository productRepository;

    public ShoppingService(ShoppingCartRepository shoppingCartRepository, ProductRepository productRepository, OrderService orderService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productRepository = productRepository;
        this.orderService = orderService;
    }

    public ShoppingCart createShoppingCart(User user) {

        ShoppingCart cart = shoppingCartRepository.save(new ShoppingCart(user));
        orderService.createOrder(user,cart);
        return cart;
    }

    public String addProductToCart(Long productId, Long shoppingCartId) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(shoppingCartId).get();
        Product product = productRepository.findById(productId).get();
        shoppingCart.getProducts().add(product);
        shoppingCart.setProducts(shoppingCart.getProducts());
        shoppingCartRepository.save(shoppingCart);
        return "adding product to cart";
    }

    public List<Product> getCart(Long shoppingCartId) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(shoppingCartId).get();
        return shoppingCart.getProducts();
    }
}
