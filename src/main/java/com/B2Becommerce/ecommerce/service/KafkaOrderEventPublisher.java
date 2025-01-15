package com.B2Becommerce.ecommerce.service;


import com.B2Becommerce.ecommerce.events.OrderCreatedNotification;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaOrderEventPublisher {

    private final KafkaTemplate<String, OrderCreatedNotification> kafkaTemplate;

//    @Value("${kafka.topic.order-created}")
    private String topic = "order_created_topic";

    public KafkaOrderEventPublisher(KafkaTemplate<String, OrderCreatedNotification> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void emitOrderCreatedEvent(OrderCreatedNotification event) {
        kafkaTemplate.send(topic, event);
    }
}
