package com.example.demo.application;

import com.example.demo.domain.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductFactory productFactory;

    public Optional<Product> getProduct(String productId) {
        return productRepository.findById(productId);
    }

    public void createProduct(String name) {
        Product product = productFactory.createProduct(name);
        productRepository.save(product);
    }
}
