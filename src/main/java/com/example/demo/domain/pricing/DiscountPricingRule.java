package com.example.demo.domain.pricing;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DiscountPricingRule implements PricingRule {
    private final int amount;
    private final float discount;


    @Override
    public int price(OrderParam param) {
        if (param.getAmount() >= amount) {
            var result = param.getProductPriceInFen() * param.getAmount() * discount;
            return Math.round(result);
        }
        return param.getProductPriceInFen() * param.getAmount();
    }
}
