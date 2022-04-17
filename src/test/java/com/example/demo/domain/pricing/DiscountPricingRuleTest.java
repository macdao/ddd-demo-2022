package com.example.demo.domain.pricing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountPricingRuleTest {
    @Test
    void two_will_20_off() {
        var param = new OrderParam(100, 2);
        var rule = new DiscountPricingRule(2, 0.8f);

        var price = rule.price(param);

        assertThat(price).isEqualTo(160);
    }

    @Test
    void one_will_be_origin_price() {
        var param = new OrderParam(100, 1);
        var rule = new DiscountPricingRule(2, 0.8f);

        var price = rule.price(param);

        assertThat(price).isEqualTo(100);
    }

    @Test
    void three_will_be_50_off() {
        var param = new OrderParam(1, 3);
        var rule = new DiscountPricingRule(2, 0.5f);

        var price = rule.price(param);

        assertThat(price).isEqualTo(2);
    }
}