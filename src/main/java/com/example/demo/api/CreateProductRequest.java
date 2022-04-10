package com.example.demo.api;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CreateProductRequest {
    @NotBlank
    private String name;
    @NotNull
    private Integer priceInFen;
}
