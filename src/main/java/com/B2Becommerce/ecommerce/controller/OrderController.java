package com.B2Becommerce.ecommerce.controller;

import com.B2Becommerce.ecommerce.model.Order;
import com.B2Becommerce.ecommerce.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/order")
public class OrderController {


    private static final Logger log = LogManager.getLogger(OrderController.class);
    @Autowired
    private OrderService orderService;

    @PostMapping("/{email}")
    public ResponseEntity<?> checkoutOrder(@PathVariable String email, @RequestBody Order order){

        try{
            Order newOrder = orderService.processOrder(email,order);
            return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("e: ", e);
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);

        }

    }

    @GetMapping
    public ResponseEntity<?> fetchAllOrders(){
        List<Order> orders  = orderService.getAll();
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }
}
