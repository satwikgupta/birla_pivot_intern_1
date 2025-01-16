package com.telusko.simpleWebApp.repository;

import com.telusko.simpleWebApp.model.Product;
import org.hibernate.mapping.PrimaryKey;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepo extends JpaRepository<Product, Integer> {

}
