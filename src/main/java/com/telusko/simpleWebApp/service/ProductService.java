package com.telusko.simpleWebApp.service;

import com.telusko.simpleWebApp.model.Product;
import com.telusko.simpleWebApp.model.ProductLog;
import com.telusko.simpleWebApp.repository.IProductLogRepo;
import com.telusko.simpleWebApp.repository.IProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    IProductRepo repo;

    @Autowired
    private ProductLogService logService;

    public List<Product> getProducts(){
        return repo.findAll();
    }

    public Product getProductById(int prodId) {
        return repo.findById(prodId).orElse(new Product());
    }

//    @Transactional
    public void addProduct(Product prod){
        repo.save(prod);

        //to simulate rollback
//        if(prod.getProdName().length() > 10)
//                throw new RuntimeException("Product Name Too long. Rolling Back...");

//        ProductLog productLog = new ProductLog();
//        productLog.setAction("Product Added");
//        productLog.setTimestamp(java.time.LocalDateTime.now());
//        productLog.setProduct(prod);

//        logService.addProductLog(productLog);
    }


    public void updateProduct(Product prod) {
        repo.save(prod);
    }

    public void deleteProduct(int prodId) {
        repo.deleteById(prodId);
    }
}