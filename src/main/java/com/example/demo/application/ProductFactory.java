package com.example.demo.application;

import com.example.demo.domain.product.Product;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProductFactory {
    public Product createProduct(String name, int priceInFen) {
        return new Product(new Product.ProductId(generateId()), name, priceInFen);
    }

    private String generateId() {
        return UUID.randomUUID().toString();
    }
}
