package com.birlaPivot.email.kafka;

import com.birlaPivot.common_models.InventoryInterface;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmailConsumer {
    @KafkaListener(topics = "quickstart-events", groupId = "test-group-2")
    public void consume(InventoryInterface inventory){
        System.out.println("Email Message: " + inventory);
    }

}
