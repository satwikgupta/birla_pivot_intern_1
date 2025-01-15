package com.ecommerce.E_Commerce.Repository;

import com.ecommerce.E_Commerce.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO extends JpaRepository<Product, String> {

}
