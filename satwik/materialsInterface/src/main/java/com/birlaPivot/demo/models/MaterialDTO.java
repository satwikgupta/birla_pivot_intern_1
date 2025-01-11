package com.birlaPivot.demo.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}

