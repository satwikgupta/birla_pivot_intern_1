package com.birlaPivot.demo.repo;

import com.birlaPivot.demo.models.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepo extends JpaRepository<Material, Integer> {
}
