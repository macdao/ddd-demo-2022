package com.example.demo.domain.pricing;

import lombok.Value;

@Value
public class OrderParam {
    int productPriceInFen;
    int amount;
}
