package com.example.demo.adapter;

import com.example.demo.domain.order.Order;
import com.example.demo.domain.product.Product;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`order`")
@Data
public class OrderEntity {
    @Id
    private String id;
    private String userId;
    private String productId;
    private int productPriceInFen;
    private int amount;
    private int orderPrice;
    String contactName;
    String contactPhone;
    String address;
}
