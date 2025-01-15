package com.ecommerce.E_Commerce.Listener;

import com.ecommerce.E_Commerce.Event.OrderPlaced;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OrderPlacedListener {

    @EventListener
    public void handleOrderPlacedEvent(OrderPlaced event) {
        System.out.println("Order placed successfully! Order ID: " + event.getOrder().getId());
    }
}
