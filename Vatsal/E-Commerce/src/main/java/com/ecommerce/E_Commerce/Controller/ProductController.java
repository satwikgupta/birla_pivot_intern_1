package com.ecommerce.E_Commerce.Controller;

import com.ecommerce.E_Commerce.Entity.Product;
import com.ecommerce.E_Commerce.Entity.User;
import com.ecommerce.E_Commerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("/addProduct")
    public ResponseEntity<String> addUserToApp(@RequestBody Product product){
        System.out.println("Received Product: " + product);
        return productService.addProduct(product);
    }
}
