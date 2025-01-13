package com.birlaPivot.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String materialType;
    private int stockInInventory;

    public void addToStockInInventory(int stockToAdd){
        this.stockInInventory += stockToAdd;
    }
}
