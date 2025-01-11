package com.B2Becommerce.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Use UUID for auto-generating unique IDs
    private String id;

    @Column(nullable = false)
    private double price;

    //getters and setters
    @Column(nullable = false)
    private int qty;

    @Column(nullable=false)
    private String description;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders; // List of orders containing this product


}
