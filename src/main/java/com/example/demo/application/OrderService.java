package com.example.demo.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final OrderFactory orderFactory;

    public void createOrder(String productId, int amount, String contactName, String contactPhone, String address) {
        var product = productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("productId:" + productId));
        int orderPrice = product.getPriceInFen() * amount;
        var order = orderFactory.createOrder(productId, product.getPriceInFen(), amount, contactName, contactPhone, address, orderPrice);
        orderRepository.save(order);
    }
}
