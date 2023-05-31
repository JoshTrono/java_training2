package com.revature.ecommerce.service;

import com.revature.ecommerce.entity.Order;
import com.revature.ecommerce.entity.ShoppingCart;
import com.revature.ecommerce.entity.User;
import com.revature.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public void createOrder(User user, ShoppingCart shoppingCart) {
        // TODO Auto-generated method stub
        orderRepository.save(new Order(user, shoppingCart));

    }
    public String getTotalPrice(int orderId) {
        Order order = orderRepository.findById(orderId).get();
        double totalPrice = 0;
        for (int i = 0; i < order.getShoppingCart().getProducts().size(); i++) {
            totalPrice += order.getShoppingCart().getProducts().get(i).getPrice();
        }
        return "Total Price: " + totalPrice;
    }

}
