package com.example.demo.adapter;

import com.example.demo.application.OrderRepository;
import com.example.demo.domain.order.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {
    private final OrderEntityRepository repository;

    @Override
    public void save(Order order) {
        var entity = new OrderEntity();
        entity.setId(order.getId().value());
        entity.setProductId(order.getProductId().value());
        entity.setProductPriceInFen(order.getProductPriceInFen());
        entity.setAmount(order.getAmount());
        entity.setOrderPrice(order.getOrderPrice());
        entity.setContactName(order.getDeliveryAddress().getContactName());
        entity.setContactPhone(order.getDeliveryAddress().getContactPhone());
        entity.setAddress(order.getDeliveryAddress().getAddress());

        repository.save(entity);
    }
}
