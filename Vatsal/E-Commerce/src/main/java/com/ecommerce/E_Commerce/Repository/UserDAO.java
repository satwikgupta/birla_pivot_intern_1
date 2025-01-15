package com.ecommerce.E_Commerce.Repository;

import com.ecommerce.E_Commerce.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User, String> {

}
