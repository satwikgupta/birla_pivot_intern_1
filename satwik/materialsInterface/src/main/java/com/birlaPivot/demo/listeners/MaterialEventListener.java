package com.birlaPivot.demo.listeners;

import com.birlaPivot.demo.events.MaterialUpdatedEvent;
import com.birlaPivot.demo.models.MaterialDTO;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MaterialEventListener {
    @EventListener
    public void handleMaterialUpdateEvent(MaterialUpdatedEvent event){
        MaterialDTO material = event.getMaterial();

        System.out.println("Event material updated: " + material);
    }

}
