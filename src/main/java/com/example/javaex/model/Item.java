package com.example.javaex.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="ITEMS")
public class Item {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer quantity;
    private double price;

    @ManyToOne
    @JoinColumn(name="cart_id", nullable=false)
    private Cart cart;
}
