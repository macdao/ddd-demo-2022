package com.example.demo.adapter;

import com.example.demo.application.ProductRepository;
import com.example.demo.domain.product.Product;
import com.example.demo.domain.product.Product.ProductId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {
    private final ProductEntityRepository repository;

    @Override
    public Optional<Product> findById(String id) {
        return repository.findById(id).map(e -> new Product(new ProductId(e.getId()), e.getName(), e.getPriceInFen()));
    }

    @Override
    public void save(Product product) {
        var entity = new ProductEntity();
        entity.setId(product.getId().value());
        entity.setName(product.getName());
        repository.save(entity);
    }
}
