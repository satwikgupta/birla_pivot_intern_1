package com.birlaPivot.demo.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "material_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    protected int price;
    protected int margin;
    protected int totalPricePerUnit;
    protected int totalPrices;

    public Material(int price, int margin) {
        this.price = price;
        this.margin = margin;
        this.totalPricePerUnit = price + margin;
    }

    public String getMaterialType() {
        return this.getClass().getSimpleName().toUpperCase();
    }

    // Getters and setters
    public int getTotalPrices() {
        return totalPrices;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMargin() {
        return margin;
    }

    public void setMargin(int margin) {
        this.margin = margin;
    }

    public int getTotalPricePerUnit() {
        return totalPricePerUnit;
    }

    public void setTotalPricePerUnit(int totalPricePerUnit) {
        this.totalPricePerUnit = totalPricePerUnit;
    }

    public void setTotalPrices(int totalPrices) {
        this.totalPrices = totalPrices;
    }

    public int getTotalPricePerBag() {
        return price + margin;
    }
}
