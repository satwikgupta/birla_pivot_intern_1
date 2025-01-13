package com.birlaPivot.demo.repo;

import com.birlaPivot.demo.models.Capital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapitalRepo extends JpaRepository<Capital, Integer> {
}
