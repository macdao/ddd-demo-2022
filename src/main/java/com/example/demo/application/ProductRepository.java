package com.example.demo.application;

import com.example.demo.domain.product.Product;

import java.util.Optional;

public interface ProductRepository {
    Optional<Product> findById(String id);

    void save(Product product);
}
