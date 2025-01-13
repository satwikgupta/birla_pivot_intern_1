package com.birlaPivot.demo.events;

import com.birlaPivot.demo.models.InventoryDTO;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class CapitalIncreaseEvent extends ApplicationEvent {
    private final InventoryDTO inventoryDTO;
    public CapitalIncreaseEvent(Object source, InventoryDTO inventoryDTO) {
        super(source);
        this.inventoryDTO = inventoryDTO;
    }
}
