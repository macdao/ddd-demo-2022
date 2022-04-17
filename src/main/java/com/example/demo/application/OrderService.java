package com.example.demo.application;

import com.example.demo.domain.pricing.OrderParam;
import com.example.demo.domain.pricing.PricingRule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final OrderFactory orderFactory;
    private final PricingRule pricingRule;

    public void createOrder(String userId, String productId, int amount, String contactName, String contactPhone, String address) {
        var product = productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("productId:" + productId));
        int orderPrice = pricingRule.price(new OrderParam(product.getPriceInFen(), amount));
        var order = orderFactory.createOrder(userId, productId, product.getPriceInFen(), amount, contactName, contactPhone, address, orderPrice);
        orderRepository.save(order);
    }
}
