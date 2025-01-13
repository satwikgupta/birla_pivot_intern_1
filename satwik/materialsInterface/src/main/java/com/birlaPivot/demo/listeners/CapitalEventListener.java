package com.birlaPivot.demo.listeners;

import com.birlaPivot.demo.events.CapitalDecreaseEvent;
import com.birlaPivot.demo.events.CapitalIncreaseEvent;
import com.birlaPivot.demo.models.Capital;
import com.birlaPivot.demo.models.InventoryDTO;
import com.birlaPivot.demo.repo.CapitalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CapitalEventListener {
    @Autowired
    private CapitalRepo capitalRepo;

    @EventListener
    public void handleCapitalIncreaseEvent(CapitalIncreaseEvent event){
        InventoryDTO inventoryDTO = event.getInventoryDTO();

        Capital capital = capitalRepo.findAll().getFirst();
        capital.addToCapital(inventoryDTO.getStock() * inventoryDTO.getPrice());

        System.out.println("Capital Updated successfully!");
    }

    public void handleCapitalDecreaseEvent(CapitalDecreaseEvent event){
        InventoryDTO inventoryDTO = event.getInventoryDTO();

        Capital capital = capitalRepo.findAll().getFirst();
//        System.out.println("Account is "+ capital);
        capital.subToCapital(inventoryDTO.getStock() * inventoryDTO.getPrice());

        System.out.println("Capital Updated successfully!");
    }
}
