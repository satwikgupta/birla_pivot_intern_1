package com.birlaPivot.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
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

    public int getTotalPricePerBag() {
        return price + margin;
    }
}
