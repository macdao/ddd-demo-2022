package com.example.demo.application;

import com.example.demo.domain.product.Product;
import com.example.demo.domain.product.Product.ProductId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Optional<Product> getProduct(String productId) {
        return productRepository.findById(productId);
    }

    public void createProduct(String id, String name) {
        var product = new Product(new ProductId(id), name);
        productRepository.save(product);
    }
}
