package com.example.demo.api.product;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetProductResponse {
    private String id;
    private String name;
    private int priceInFen;
}
