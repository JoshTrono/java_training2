package com.revature.shoppingcart;
import java.util.ArrayList;

class Product {
    private String name;
    private double price;

    // Constructor
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getters and setters
    public double getPrice() {
        return this.price;
    }
    public String getName() {
        return this.name;
    }
}

class ShoppingCart {

    ArrayList<Product> products = new ArrayList<Product>();
    public void addProduct(Product product) {
        products.add(product);
    }
    public void removeProduct(Product product) {
        products.remove(product);
    }
    public double getTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }
    public void displayCart() {
        System.out.println("Your items in your cart:");
        for (Product product: products) {
            System.out.println(product.getName() + ", price: " + product.getPrice());
        }
    }
}

public class ShoppingCartDemo {
    public static void main(String[] args) {
        // Create Product objects
        Product product1 = new Product("apple", 0.99);
        Product product2 = new Product("52 inch TV", 599);
        Product product3 = new Product("New Laptop", 1000);
        Product product4 = new Product("Legend of Zelda: Tears of the Kingdom", 60.00);
        // Create an instance of ShoppingCart
        ShoppingCart cart = new ShoppingCart();
        // Add products to the cart
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product3);
        cart.addProduct(product4);
        // Remove a product from the cart
        cart.removeProduct(product3);
        // Calculate and display the total price of the cart
        System.out.println("Total price of the cart is: " + cart.getTotalPrice());
        // Display the items in the cart
        cart.displayCart();
    }
}