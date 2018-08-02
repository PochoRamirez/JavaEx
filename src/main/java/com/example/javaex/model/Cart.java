package com.example.javaex.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name="CART")
public class Cart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "cart")
    private Set<Item> items;

    public double getTotal() {
        double a = this.items != null && items.size() > 0 ? items.stream().mapToDouble(s -> s.getQuantity() * s.getPrice()).sum() : 0;
        return a;
    }
}
