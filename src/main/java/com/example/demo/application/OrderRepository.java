package com.example.demo.application;

import com.example.demo.domain.order.Order;

public interface OrderRepository {
    void save(Order order);

}
