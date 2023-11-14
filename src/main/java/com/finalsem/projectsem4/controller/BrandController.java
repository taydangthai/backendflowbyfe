package com.finalsem.projectsem4.controller;

import com.finalsem.projectsem4.common.ResponseBuilder;
import com.finalsem.projectsem4.dto.BrandsDTO;
import com.finalsem.projectsem4.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ly Quoc Trong
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/brands")
public class BrandController {
    private final BrandService service;

    public BrandController(BrandService service) {
        this.service = service;
    }

    @GetMapping("/all")
    ResponseEntity<?> getAllBrand() {
        ResponseBuilder<List<BrandsDTO>> resp = service.getAllBrand();
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PostMapping("/create")
    ResponseEntity<?> createBrand(@RequestBody BrandsDTO dto) {
        ResponseBuilder<BrandsDTO> resp = service.createBrand(dto);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<?> updateBrand(@PathVariable Long id, @RequestBody BrandsDTO dto) {
        ResponseBuilder<BrandsDTO> resp = service.updateBrand(id, dto);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteBrand(@PathVariable Long id) {
        ResponseBuilder<?> resp = service.deleteBrand(id);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    ResponseEntity<?> getBrandById(@PathVariable Long id) {
        ResponseBuilder<BrandsDTO> resp = service.getBrandById(id);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
