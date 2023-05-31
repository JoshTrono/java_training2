package com.revature.ecommerce.service;

import com.revature.ecommerce.entity.Product;
import com.revature.ecommerce.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        productService = new ProductService(productRepository);
    }

    @Test
    public void testSearchProducts() {
        String category = "electronics";
        List<Product> productList = Arrays.asList(
                new Product("Product1", "electronics", "Description1", 9.99),
                new Product("Product2", "electronics", "Description2", 19.99)
        );

        doNothing().when(productRepository).findByCategory(category);

        String result = productService.searchProducts(category);

        verify(productRepository, times(1)).findByCategory(category);
        assertEquals("searching products", result);
    }

    @Test
    public void testAddProduct() {
        String name = "New Product";
        String category = "electronics";
        String description = "New Product Description";
        double price = 29.99;

        String result = productService.addProduct(name, category, description, price);

        verify(productRepository, times(1)).save(any(Product.class));
        assertEquals("adding product", result);
    }

    @Test
    public void testGetAllProducts() {
        List<Product> productList = Arrays.asList(
                new Product("Product1", "electronics", "Description1", 9.99),
                new Product("Product2", "electronics", "Description2", 19.99)
        );

        when(productRepository.findAll()).thenReturn(productList);

        List<Product> result = productService.getAllProducts();

        verify(productRepository, times(1)).findAll();
        assertEquals(productList, result);
    }
}
