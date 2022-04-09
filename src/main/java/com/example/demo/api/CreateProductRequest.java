package com.example.demo.api;

import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class CreateProductRequest {
    @NotBlank
    String id;
    String name;
}
