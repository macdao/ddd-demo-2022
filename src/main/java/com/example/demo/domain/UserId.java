package com.example.demo.domain;

import lombok.Value;

public class UserId extends Identity<String> {
    public UserId(String value) {
        super(value);
    }
}
