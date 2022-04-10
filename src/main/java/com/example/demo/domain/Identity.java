package com.example.demo.domain;

public class Identity<T> {
    private final T value;

    public Identity(T value) {
        this.value = value;
    }

    public T value() {
        return value;
    }
}
