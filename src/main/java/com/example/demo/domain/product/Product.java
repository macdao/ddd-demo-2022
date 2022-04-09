package com.example.demo.domain.product;

import lombok.Getter;
import lombok.Value;

@Getter
public class Product {
    private final ProductId id;
    private String name;

    public Product(ProductId id, String name) {
        this.id = id;
        this.name = name;
    }

    @Value
    public static class ProductId {
        String id;

        public String value() {
            return id;
        }
    }
}
