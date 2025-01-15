package com.birlaPivot.common_models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InventoryInterface {
    private int id;
    private String materialType;
    private int stockInInventory;

    public InventoryInterface(int id, String materialType, int stockInInventory) {
        this.id = id;
        this.materialType = materialType;
        this.stockInInventory = stockInInventory;
    }

    @Override
    public String toString() {
        return "InventoryInterface{" +
                "id=" + id +
                ", materialType='" + materialType + '\'' +
                ", stockInInventory=" + stockInInventory +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public int getStockInInventory() {
        return stockInInventory;
    }

    public void setStockInInventory(int stockInInventory) {
        this.stockInInventory = stockInInventory;
    }
}