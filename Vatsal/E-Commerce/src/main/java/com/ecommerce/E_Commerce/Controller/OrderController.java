package com.ecommerce.E_Commerce.Controller;

import com.ecommerce.E_Commerce.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/placeOrder/{userId}")
    public ResponseEntity<?> placeOrder(@PathVariable String userId,
                                             @RequestParam List<String> productIds,
                                             @RequestParam List<Integer> quantity){
        System.out.println("Order Started : ");
        System.out.println("UserId: " + userId);
        System.out.println("ProductIds: " + productIds);
        System.out.println("Quantity: " + quantity);
        return orderService.placeOrder(userId,productIds,quantity);
    }
}
