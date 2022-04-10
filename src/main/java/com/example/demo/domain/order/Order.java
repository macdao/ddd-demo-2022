package com.example.demo.domain.order;

import com.example.demo.domain.Identity;
import com.example.demo.domain.UserId;
import com.example.demo.domain.product.Product.ProductId;
import lombok.Getter;
import lombok.Value;

@Getter
public class Order {
    private final OrderId id;
    private final UserId userId;
    private ProductId productId;
    private int productPriceInFen;
    private int amount;
    private int orderPrice;
    private DeliveryAddress deliveryAddress;

    public Order(OrderId id, UserId userId, ProductId productId, int productPriceInFen, int amount, int orderPrice, DeliveryAddress deliveryAddress) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.productPriceInFen = productPriceInFen;
        this.amount = amount;
        this.deliveryAddress = deliveryAddress;
        this.orderPrice = orderPrice;
    }

    public static class OrderId extends Identity<String> {
        public OrderId(String value) {
            super(value);
        }
    }

    @Value
    public static class DeliveryAddress {
        String contactName;
        String contactPhone;
        String address;
    }
}
