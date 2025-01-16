package com.birlaPivot.demo.services;

import com.birlaPivot.common_models.InventoryInterface;
import com.birlaPivot.demo.events.CapitalIncreaseEvent;
import com.birlaPivot.demo.kafka.producer.MessageProducer;
import com.birlaPivot.demo.models.Inventory;
import com.birlaPivot.demo.models.InventoryDTO;
import com.birlaPivot.demo.repo.CapitalRepo;
import com.birlaPivot.demo.repo.InventoryRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    MessageProducer messageProducer;

    @Autowired
    private InventoryRepo inventoryRepo;

    @Autowired
    private CapitalRepo capitalRepo;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public ResponseEntity<List<Inventory>> getAllInventory(){
        try {
            List<Inventory> inventories = inventoryRepo.findAll();

            InventoryInterface inventoryInterface = new InventoryInterface(inventories.getFirst().getId(), inventories.getFirst().getMaterialType(), inventories.getFirst().getStockInInventory());
            messageProducer.sendMessage(inventoryInterface);

            return new ResponseEntity<>(inventories, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<String> addInventoryItem(Inventory inventory){
        try {
            inventoryRepo.save(inventory);
            return new ResponseEntity<>("Successfully added!", HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public ResponseEntity<Inventory>  addToInventory(InventoryDTO inventoryDTO){
        try {
            Inventory inventory = inventoryRepo.findByMaterialType(inventoryDTO.getMaterialType())
                    .orElseThrow(() -> new RuntimeException("Material not found"));
//            System.out.println("Material Found!");
            inventory.addToStockInInventory(inventoryDTO.getStock());

            applicationEventPublisher.publishEvent(new CapitalIncreaseEvent(this, inventoryDTO));

//            System.out.println("Event completed here!");

            return new ResponseEntity<>(inventoryRepo.findByMaterialType(inventoryDTO.getMaterialType()).get()
                    ,HttpStatus.OK);

        } catch (Exception e) {
            System.out.println("Error encountered: \n");
            throw new RuntimeException(e);
        }
    }


}
