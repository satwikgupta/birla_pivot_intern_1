package com.birlaPivot.demo.controller;

import com.birlaPivot.demo.models.Cement;
import com.birlaPivot.demo.models.Material;
import com.birlaPivot.demo.models.MaterialDTO;
import com.birlaPivot.demo.models.SteelBar;
import com.birlaPivot.demo.services.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping("all")
    public ResponseEntity<List<MaterialDTO>> getAllMaterial(){
        return materialService.getAllMaterial();
    }

    @PostMapping("cement")
    public ResponseEntity<String> addCement(@RequestBody Cement cement){
        return materialService.addCement(cement);
    }

    @PostMapping("steelbar")
    public ResponseEntity<String> addSteelBars(@RequestBody SteelBar steelBar){
        return materialService.addSteelBar(steelBar);
    }

    @GetMapping("order/{id}")
    public ResponseEntity<MaterialDTO> getMaterialById(@PathVariable int id){
        return materialService.getMaterialById(id);
    }

    @DeleteMapping("order/{id}")
    public ResponseEntity<String> deleteMaterialById(@PathVariable int id){
        return materialService.deleteMaterialById(id);
    }

    @PatchMapping("order/{id}")
    public ResponseEntity<MaterialDTO> patchMaterialById(@PathVariable int id, @RequestBody MaterialDTO material){
        return materialService.patchMaterialById(id, material);
    }
}
