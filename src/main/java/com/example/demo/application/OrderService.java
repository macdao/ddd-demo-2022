package com.example.demo.application;

import com.example.demo.domain.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final OrderFactory orderFactory;

    public void createOrder(String userId, String productId, int amount, String contactName, String contactPhone, String address) {
        var product = productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("productId:" + productId));
        int orderPrice = calculateOrderPrice(amount, product);
        var order = orderFactory.createOrder(userId, productId, product.getPriceInFen(), amount, contactName, contactPhone, address, orderPrice);
        orderRepository.save(order);
    }

    private int calculateOrderPrice(int amount, Product product) {
        return product.getPriceInFen() * amount;
    }
}
