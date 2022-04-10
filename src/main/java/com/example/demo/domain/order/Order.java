package com.example.demo.domain.order;

import com.example.demo.domain.product.Product.ProductId;
import lombok.Getter;
import lombok.Value;

@Getter
public class Order {
    private final OrderId id;
    private ProductId productId;
    private int productPriceInFen;
    private int amount;
    private int orderPrice;
    private DeliveryAddress deliveryAddress;

    public Order(OrderId id, ProductId productId, int productPriceInFen, int amount, int orderPrice, DeliveryAddress deliveryAddress) {
        this.id = id;
        this.productId = productId;
        this.productPriceInFen = productPriceInFen;
        this.amount = amount;
        this.deliveryAddress = deliveryAddress;
        this.orderPrice = orderPrice;
    }

    @Value
    public static class OrderId {
        String value;

        public String value() {
            return value;
        }
    }

    @Value
    public static class DeliveryAddress {
        String contactName;
        String contactPhone;
        String address;
    }
}
