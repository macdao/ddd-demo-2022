package com.example.demo.domain.product;

import com.example.demo.domain.Identity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Product {
    private final ProductId id;
    private String name;
    private int priceInFen;

    public static class ProductId extends Identity<String> {
        public ProductId(String value) {
            super(value);
        }
    }
}
