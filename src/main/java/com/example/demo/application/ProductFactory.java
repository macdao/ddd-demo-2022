package com.example.demo.application;

import com.example.demo.domain.product.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Component
public class ProductFactory {
    public Product createProduct(String name) {
        return new Product(new Product.ProductId(generateId()), name);
    }

    private String generateId() {
        return UUID.randomUUID().toString();
    }
}
