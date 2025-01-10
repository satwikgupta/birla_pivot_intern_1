package com.birlaPivot.demo.models;

import lombok.Data;

@Data
public class MaterialDTO {
    private int id;
    private int price;
    private int margin;
    private int totalPricePerUnit;
    private int totalPrices;
    private int numberOfBags;
    private int units;
    private int totalPricePerBag;
    private String materialType;

    public MaterialDTO(int id, int price, int margin, int totalPricePerUnit, int totalPrices, int numberOfBags, int units, int totalPricePerBag, String materialType) {
        this.id = id;
        this.price = price;
        this.margin = margin;
        this.totalPricePerUnit = totalPricePerUnit;
        this.totalPrices = totalPrices;
        this.numberOfBags = numberOfBags;
        this.units = units;
        this.totalPricePerBag = totalPricePerBag;
        this.materialType = materialType;
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

    public int getTotalPrices() {
        return totalPrices;
    }

    public void setTotalPrices(int totalPrices) {
        this.totalPrices = totalPrices;
    }

    public int getNumberOfBags() {
        return numberOfBags;
    }

    public void setNumberOfBags(int numberOfBags) {
        this.numberOfBags = numberOfBags;
    }

    public int getTotalPricePerBag() {
        return totalPricePerBag;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public void setTotalPricePerBag(int totalPricePerBag) {
        this.totalPricePerBag = totalPricePerBag;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }
}

