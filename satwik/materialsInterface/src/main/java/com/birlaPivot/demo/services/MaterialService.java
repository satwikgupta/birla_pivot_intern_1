package com.birlaPivot.demo.services;

import com.birlaPivot.demo.models.Cement;
import com.birlaPivot.demo.models.Material;
import com.birlaPivot.demo.models.MaterialDTO;
import com.birlaPivot.demo.models.SteelBar;
import com.birlaPivot.demo.repo.MaterialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepo materialRepo;


    public ResponseEntity<List<MaterialDTO>> getAllMaterial() {
        try{
            List<Material> materials = materialRepo.findAll();
            return new ResponseEntity<>(materials.stream().map(material -> {
                String materialType = material.getMaterialType();
                return new MaterialDTO(
                        material.getId(),
                        material.getPrice(),
                        material.getMargin(),
                        material.getTotalPricePerUnit(),
                        material.getTotalPrices(),
                        (material instanceof Cement) ? ((Cement) material).getNumberOfBags() : 0,
                        (material instanceof SteelBar) ? ((SteelBar) material).getUnits() : 0,
                        material.getTotalPricePerBag(),
                        materialType
                );
            }).collect(Collectors.toList()), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<String> addCement(Cement cement) {
        try {
            materialRepo.save(cement);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<String> addSteelBar(SteelBar steelBar) {
        try {
            materialRepo.save(steelBar);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<MaterialDTO> getMaterialById(int id) {
        try {
            Optional<Material> materialOptional = materialRepo.findById(id);

            if(materialOptional.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            Material material = materialOptional.get();

            String materialType = material.getMaterialType();
            MaterialDTO materialDTO = new MaterialDTO(
                    material.getId(),
                    material.getPrice(),
                    material.getMargin(),
                    material.getTotalPricePerUnit(),
                    material.getTotalPrices(),
                    (material instanceof Cement) ? ((Cement) material).getNumberOfBags() : 0,
                    (material instanceof SteelBar) ? ((SteelBar) material).getUnits() : 0,
                    material.getTotalPricePerBag(),
                    materialType
            );

            return new ResponseEntity<>(materialDTO, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<String> deleteMaterialById(int id) {
        try {
            materialRepo.deleteById(id);
            return new ResponseEntity<>("Order deleted successfully!", HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<MaterialDTO> patchMaterialById(int id, MaterialDTO materialDTO) {
        try {
            Optional<Material> materialOptional = materialRepo.findById(id);

            if (materialOptional.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            Material material = materialOptional.get();

            if ("CEMENT".equalsIgnoreCase(materialDTO.getMaterialType()) && material instanceof Cement) {
                Cement cement = (Cement) material;
                cement.setPrice(materialDTO.getPrice());
                cement.setMargin(materialDTO.getMargin());
                cement.setTotalPricePerUnit(materialDTO.getPrice() + materialDTO.getMargin());
                cement.calculateTotalPrice();

            } else if ("STEELBAR".equalsIgnoreCase(materialDTO.getMaterialType()) && material instanceof SteelBar) {
                SteelBar steelBar = (SteelBar) material;
                steelBar.setPrice(materialDTO.getPrice());
                steelBar.setMargin(materialDTO.getMargin());
                steelBar.setTotalPricePerUnit(materialDTO.getPrice() + materialDTO.getMargin());
                steelBar.calculateTotalPrice();
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            materialRepo.save(material);

            MaterialDTO updatedMaterialDTO = new MaterialDTO(
                    material.getId(),
                    material.getPrice(),
                    material.getMargin(),
                    material.getTotalPricePerUnit(),
                    material.getTotalPrices(),
                    (material instanceof Cement) ? ((Cement) material).getNumberOfBags() : 0,
                    (material instanceof SteelBar) ? ((SteelBar) material).getUnits() : 0,
                    material.getTotalPricePerBag(),
                    material.getMaterialType()
            );

            return new ResponseEntity<>(updatedMaterialDTO, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
