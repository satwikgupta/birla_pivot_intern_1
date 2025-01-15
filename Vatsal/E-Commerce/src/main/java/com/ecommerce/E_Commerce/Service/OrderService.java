package com.ecommerce.E_Commerce.Service;

import com.ecommerce.E_Commerce.Entity.Order;
import com.ecommerce.E_Commerce.Entity.OrderItem;
import com.ecommerce.E_Commerce.Entity.Product;
import com.ecommerce.E_Commerce.Entity.User;
import com.ecommerce.E_Commerce.Event.OrderPlaced;
import com.ecommerce.E_Commerce.Repository.OrderDAO;
import com.ecommerce.E_Commerce.Repository.ProductDAO;
import com.ecommerce.E_Commerce.Repository.UserDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private ProductDAO productDao;

    @Autowired
    private OrderDAO orderDao;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Transactional
    public ResponseEntity<?> placeOrder(String userId, List<String> productIds, List<Integer> quantity) {
        // Fetch the user
        System.out.println("Inside Place Order");
        User user = userDao.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found"));
        System.out.println("User " + user);

        List<OrderItem> orderItems = new ArrayList<>();
        double totalPrice = 0.0;

        for(int i = 0; i < productIds.size(); i++){
            Product product = productDao.findById(productIds.get(i)).orElseThrow(() -> new RuntimeException("Product Not Found"));
            int updatedQuantity = Integer.parseInt(product.getQuantity()) - quantity.get(i);
            if(updatedQuantity < 0){
                throw new RuntimeException("Insufficient stock for product: " + product.getName());
            }

            product.setQuantity(String.valueOf(updatedQuantity));
            productDao.save(product);

            // Create an order item for the product
            OrderItem item = new OrderItem();
            item.setProduct(product);
            item.setQuantity(quantity.get(i));
            item.setPrice(quantity.get(i) * 100.0);
            totalPrice += item.getPrice();
            orderItems.add(item);
        }

        // Create and save order
        Order order = new Order();
        order.setUser(user);
        order.setOrderItems(orderItems);
        order.setTotalPrice(totalPrice);

        System.out.println("Order : " + order);

        // Link each order item to the order
        for(OrderItem item : orderItems) {
            item.setOrder(order);
        }

        orderDao.save(order);
        eventPublisher.publishEvent(new OrderPlaced(this, order));

        return new ResponseEntity<>("Order placed successfully with ID: " + order.getId(), HttpStatus.OK);
    }
}
