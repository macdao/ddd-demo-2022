package com.example.demo.domain.pricing;

public interface PricingRule {
    int price(OrderParam param);
}
