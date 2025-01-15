package com.ecommerce.E_Commerce.Event;

import com.ecommerce.E_Commerce.Entity.Order;
import org.springframework.context.ApplicationEvent;

public class OrderPlaced extends ApplicationEvent {

    private final Order order;

    public OrderPlaced(Object source, Order order) {
        super(source);
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

}
