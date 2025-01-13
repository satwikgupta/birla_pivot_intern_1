package com.birlaPivot.demo.repo;

import com.birlaPivot.demo.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory, Integer> {
    Optional<Inventory> findByMaterialType(String materialType);
}
