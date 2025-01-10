package com.birlaPivot.demo.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@DiscriminatorValue("STEELBAR")
public class SteelBar extends Material {
    private int units;

    public SteelBar() {
        super(0, 0);
    }

    public SteelBar(int price, int margin, int units) {
        super(price, margin);
        this.units = units;
        calculateTotalPrice();
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public void calculateTotalPrice() {
        totalPrices = totalPricePerUnit * units;
    }

    @Override
    public String toString() {
        return "SteelBar {" +
                "units=" + units +
                ", price=" + price +
                ", margin=" + margin +
                ", totalPrices=" + totalPrices +
                '}';
    }
}
