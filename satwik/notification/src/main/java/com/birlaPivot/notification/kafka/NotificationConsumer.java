package com.birlaPivot.notification.kafka;

import com.birlaPivot.common_models.InventoryInterface;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {
    @KafkaListener(topics = "quickstart-events", groupId = "test-group-1")
    public void consume(InventoryInterface inventory){
        System.out.println("Notification Message: " + inventory);
    }

}
