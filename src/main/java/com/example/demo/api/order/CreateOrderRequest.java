package com.example.demo.api.order;

import lombok.Data;

@Data
public class CreateOrderRequest {
    private String productId;
    private int amount;
    private DeliveryAddress deliveryAddress;

    @Data
    public static class DeliveryAddress {
        private String contactName;
        private String contactPhone;
        private String address;
    }
}
