package com.example.demo.application;

import com.example.demo.domain.product.Product;
import com.example.demo.domain.product.Product.ProductId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductFactory {
    private final IdGenerator idGenerator;

    public Product createProduct(String name, int priceInFen) {
        return new Product(new ProductId(idGenerator.generateId()), name, priceInFen);
    }
}
