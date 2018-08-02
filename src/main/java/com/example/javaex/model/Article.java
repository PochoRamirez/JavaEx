package com.example.javaex.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Item implements Serializable {

    private Long id;
    private String title;
    private double price;
}
