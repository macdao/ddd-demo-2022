package com.example.demo.domain.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Getter
@AllArgsConstructor
public class Product {
    private final ProductId id;
    private String name;
    private int priceInFen;

    @Value
    public static class ProductId {
        String id;

        public String value() {
            return id;
        }
    }
}
