package com.example.demo.application;

import com.example.demo.domain.pricing.CompositePricingRule;
import com.example.demo.domain.pricing.DiscountPricingRule;
import com.example.demo.domain.pricing.PricingRule;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("demo.pricing")
@Setter
public class PricingRuleFactory {
    private int amount;
    private float discount;

    @Bean
    PricingRule pricingRule() {
        return new CompositePricingRule(List.of(new DiscountPricingRule(amount, discount)));
    }
}
