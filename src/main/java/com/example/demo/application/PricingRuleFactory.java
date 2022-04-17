package com.example.demo.application;

import com.example.demo.domain.pricing.CompositePricingRule;
import com.example.demo.domain.pricing.DiscountPricingRule;
import com.example.demo.domain.pricing.PricingRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PricingRuleFactory {
    @Bean
    PricingRule pricingRule() {
        return new CompositePricingRule(List.of(new DiscountPricingRule(2, 0.8f)));
    }
}
