package com.ecommerce.E_Commerce.Service;

import com.ecommerce.E_Commerce.Entity.Product;
import com.ecommerce.E_Commerce.Repository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDAO productDAO;

    public ResponseEntity<List<Product>> getAllProducts() {
        try{
            return new ResponseEntity<>(productDAO.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addProduct(Product product) {
        System.out.println("Product to be saved: " + product);
        productDAO.save(product);
        return new ResponseEntity<>("Successfully Added Product to Application", HttpStatus.CREATED);
    }
}
