package com.example.demo.domain.pricing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CompositePricingRuleTest {
    @Test
    void will_return_lowset_price() {
        var rule1 = mock(PricingRule.class);
        var rule2 = mock(PricingRule.class);
        var rule3 = mock(PricingRule.class);
        var orderParam = new OrderParam(1, 1);
        when(rule1.price(orderParam)).thenReturn(100);
        when(rule2.price(orderParam)).thenReturn(50);
        when(rule3.price(orderParam)).thenReturn(200);
        var compositePricingRule = new CompositePricingRule(List.of(rule1, rule2, rule3));

        var price = compositePricingRule.price(orderParam);

        assertThat(price).isEqualTo(50);
    }
}