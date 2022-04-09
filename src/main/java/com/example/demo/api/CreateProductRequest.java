package com.example.demo.api;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateProductRequest {
    @NotBlank
    private String name;
}
