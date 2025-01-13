package com.birlaPivot.demo.controller;

import com.birlaPivot.demo.models.Inventory;
import com.birlaPivot.demo.models.InventoryDTO;
import com.birlaPivot.demo.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping("all")
    public ResponseEntity<List<Inventory>> getAllInventory(){
        return inventoryService.getAllInventory();
    }

    @PostMapping("new")
    public ResponseEntity<String> createNewInventoryItem(@RequestBody Inventory inventory){
        return inventoryService.addInventoryItem(inventory);
    }

    @PutMapping("update")
    public ResponseEntity<Inventory> addToInventory(@RequestBody InventoryDTO inventoryDTO){
        return inventoryService.addToInventory(inventoryDTO);
    }

}
