package com.telusko.simpleWebApp.service;

import com.telusko.simpleWebApp.model.ProductLog;
import com.telusko.simpleWebApp.repository.IProductLogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductLogService {

    @Autowired
    private IProductLogRepo logRepo;

    public void addProductLog(ProductLog log){
        this.logRepo.save(log);
    }
}
