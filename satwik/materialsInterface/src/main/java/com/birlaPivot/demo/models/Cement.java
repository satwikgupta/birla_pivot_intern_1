package com.birlaPivot.demo.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("CEMENT")
public class Cement extends Material {
    private int numberOfBags;

    public Cement(int price, int margin, int numberOfBags) {
        super(price, margin);
        this.numberOfBags = numberOfBags;
        calculateTotalPrice();
    }

    public int getNumberOfBags() {
        return numberOfBags;
    }

    public void setNumberOfBags(int numberOfBags) {
        this.numberOfBags = numberOfBags;
    }

    public void calculateTotalPrice() {
        totalPrices = totalPricePerUnit * numberOfBags;
    }

    @Override
    public String toString() {
        return "Cement {" +
                "numberOfBags=" + numberOfBags +
                ", price=" + price +
                ", margin=" + margin +
                ", totalPrice=" + totalPrices +
                '}';
    }
}
