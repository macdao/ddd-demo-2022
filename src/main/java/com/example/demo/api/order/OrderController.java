package com.example.demo.api.order;

import com.example.demo.api.order.CreateOrderRequest.DeliveryAddress;
import com.example.demo.application.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(CREATED)
    public void postOrders(@RequestBody @Valid CreateOrderRequest request) {
        DeliveryAddress deliveryAddress = request.getDeliveryAddress();
        orderService.createOrder(request.getProductId(), request.getAmount(), deliveryAddress.getContactName(), deliveryAddress.getContactPhone(), deliveryAddress.getAddress());
    }
}
