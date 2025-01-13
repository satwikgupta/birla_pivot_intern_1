package com.birlaPivot.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Capital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int workingBalance;

    public void addToCapital(int balance){
        this.workingBalance += balance;
    }
    public void subToCapital(int balance){
        this.workingBalance -= balance;
    }
}
