package com.example.demo.application;

import com.example.demo.domain.order.Order;
import com.example.demo.domain.pricing.OrderParam;
import com.example.demo.domain.pricing.PricingRule;
import com.example.demo.domain.product.Product;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.*;

class OrderServiceTest {
    @Test
    void create_order_should_call_repo() {
        String productId = "product-id";
        int amount = 10;
        String contactName = "Josh";
        String contactPhone = "13888888888";
        String address = "Shanghai";
        String userId = "user-id";
        int productPriceInFen = 10000;
        int orderPrice = 100000;
        var order = mock(Order.class);

        var pricingRule = mock(PricingRule.class);
        when(pricingRule.price(new OrderParam(productPriceInFen, amount))).thenReturn(orderPrice);

        var productRepository = mock(ProductRepository.class);
        var product = mock(Product.class);
        when(product.getPriceInFen()).thenReturn(productPriceInFen);
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));

        var orderRepository = mock(OrderRepository.class);

        var orderFactory = mock(OrderFactory.class);
        when(orderFactory.createOrder(userId, productId, productPriceInFen, amount, contactName, contactPhone, address, orderPrice)).thenReturn(order);
        var orderService = new OrderService(productRepository, orderRepository, orderFactory, pricingRule);

        orderService.createOrder(userId, productId, amount, contactName, contactPhone, address);

        verify(orderRepository).save(order);
    }
}