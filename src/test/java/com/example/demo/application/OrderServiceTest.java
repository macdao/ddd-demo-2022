package com.example.demo.application;

import com.example.demo.domain.order.Order;
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
        int productPriceInFen = 10000;
        var order = mock(Order.class);

        var productRepository = mock(ProductRepository.class);
        var product = mock(Product.class);
        when(product.getPriceInFen()).thenReturn(productPriceInFen);
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));

        var orderRepository = mock(OrderRepository.class);

        var orderFactory = mock(OrderFactory.class);
        when(orderFactory.createOrder(productId, productPriceInFen, amount, contactName, contactPhone, address, 100000)).thenReturn(order);
        var orderService = new OrderService(productRepository, orderRepository, orderFactory);

        orderService.createOrder(productId, amount, contactName, contactPhone, address);

        verify(orderRepository).save(order);
    }
}