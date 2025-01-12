package com.B2Becommerce.ecommerce.service;

import com.B2Becommerce.ecommerce.events.OrderCreatedEvent;
import com.B2Becommerce.ecommerce.model.Order;
import com.B2Becommerce.ecommerce.model.Product;
import com.B2Becommerce.ecommerce.repo.OrderRepo;
import com.B2Becommerce.ecommerce.repo.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private UserService userService;



    public double calculateSubtotal(List<Product> productsInCart) {
        return productsInCart.stream()
                .mapToDouble(productInCart -> {
                    // Fetch the product from the database
                    Product productFromDb = productRepo
                            .findById(productInCart.getId())
                            .orElse(null);

                    return productFromDb != null ? productFromDb.getPrice() : 0;

                })
                .sum();
    }


    @Transactional
    public Order processOrder(String email, Order order) throws Exception {
        // Validate and update quantities for all products in the order
        List<Product> products = order.getProducts();
        for (Product product : products) {
            productService.updateQty(product.getId());
        }

        // Associate the order with the user
        userService.addUserOrders(email, order);

        // Perform final validation and save the order
        return createOrder(order);
    }



    public Order createOrder(Order order) throws Exception {
        // Validate order details
        if (order == null || order.getProducts().isEmpty()) {
            throw new Exception("Order is empty or invalid.");
        }

        double calculatedTotal = calculateSubtotal(order.getProducts());
        if (calculatedTotal != order.getTotal_amount()) {
            throw new Exception("Order amount mismatch; cart tampered.");
        }

        // Save the order explicitly (only once here)
        Order newOrder = orderRepo.save(order);

        // Publish an event after the order is successfully created
        eventPublisher.publishEvent(new OrderCreatedEvent(order));

        return newOrder;
    }


    public List<Order> getAll(){
        return orderRepo.findAll();
    }
}
