package com.example.demo.domain.pricing;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CompositePricingRule implements PricingRule {
    private final List<PricingRule> rules;

    @Override
    public int price(OrderParam param) {
        return rules.stream()
                .mapToInt(rule -> rule.price(param))
                .min().orElseThrow(IllegalStateException::new);
    }
}
