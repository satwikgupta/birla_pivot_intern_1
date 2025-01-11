package com.birlaPivot.demo.events;

import com.birlaPivot.demo.models.MaterialDTO;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class MaterialUpdatedEvent extends ApplicationEvent {
    private final MaterialDTO material;
    public MaterialUpdatedEvent(Object source, MaterialDTO material) {
        super(source);
        this.material = material;
    }
}
