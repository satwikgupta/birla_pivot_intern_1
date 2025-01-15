package com.birlaPivot.demo.kafka.producer;

import com.birlaPivot.common_models.InventoryInterface;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    private final KafkaTemplate<String, InventoryInterface> kafkaTemplate;

    private String topic = "quickstart-events";

    public MessageProducer(KafkaTemplate<String, InventoryInterface> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(InventoryInterface message){
        kafkaTemplate.send(topic, message);
    }
}
