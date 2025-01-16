package com.telusko.simpleWebApp.repository;

import com.telusko.simpleWebApp.model.Product;
import com.telusko.simpleWebApp.model.ProductLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductLogRepo extends JpaRepository<ProductLog, Integer> {
}
