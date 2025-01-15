package com.ecommerce.E_Commerce.Repository;

import com.ecommerce.E_Commerce.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO extends JpaRepository<Order, String> {

}
