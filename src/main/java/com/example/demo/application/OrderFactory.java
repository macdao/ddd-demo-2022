package com.example.demo.application;

import com.example.demo.domain.UserId;
import com.example.demo.domain.order.Order;
import com.example.demo.domain.order.Order.DeliveryAddress;
import com.example.demo.domain.order.Order.OrderId;
import com.example.demo.domain.product.Product.ProductId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderFactory {
    private final IdGenerator idGenerator;

    public Order createOrder(String userId, String productId, int productPriceInFen, int amount, String contactName, String contactPhone, String address, int orderPrice) {
        var deliveryAddress = new DeliveryAddress(contactName, contactPhone, address);
        var orderId = new OrderId(idGenerator.generateId());
        return new Order(orderId, new UserId(userId), new ProductId(productId), productPriceInFen, amount, orderPrice, deliveryAddress);
    }
}
