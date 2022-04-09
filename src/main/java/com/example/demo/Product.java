package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Product {
    @Id
    @NotBlank
    private String id;
    private String name;

    public Product() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
