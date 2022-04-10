package com.example.demo.adapter;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
@Data
public class ProductEntity {
    @Id
    private String id;
    private String name;
    private int priceInFen;
}
