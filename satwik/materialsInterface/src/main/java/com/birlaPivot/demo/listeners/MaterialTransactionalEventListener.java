package com.birlaPivot.demo.listeners;

import com.birlaPivot.demo.events.MaterialUpdatedEvent;
import com.birlaPivot.demo.models.MaterialDTO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class MaterialTransactionalEventListener {
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleMaterialUpdatedAfterCommit(MaterialUpdatedEvent event){
        MaterialDTO material = event.getMaterial();

        System.out.println("This is the notification that " + material + " has been successfully updated!");
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void handleMaterialUpdatedAfterRollback(MaterialUpdatedEvent event){
        MaterialDTO material = event.getMaterial();

        System.out.println("No changes has made to " + material);
    }

}
