package com.finalsem.projectsem4.controller;

import com.finalsem.projectsem4.common.ResponseBuilder;
import com.finalsem.projectsem4.dto.ProductImagesDTO;
import com.finalsem.projectsem4.service.ProductImageService;
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
@RequestMapping("/api/product-images")
public class ProductImageController {

    private final ProductImageService productImageService;


    public ProductImageController(ProductImageService productImageService) {
        this.productImageService = productImageService;
    }

    @GetMapping("/all")
    ResponseEntity<?> getAllProductImages() {
        ResponseBuilder<List<ProductImagesDTO>> resp = productImageService.getAllProductImage();
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    ResponseEntity<?> getProductImageById(@PathVariable Long id) {
        ResponseBuilder<ProductImagesDTO> resp = productImageService.getProductImageById(id);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/get/product/{id}")
    ResponseEntity<?> getProductImageByProductId(@PathVariable Long id) {
        ResponseBuilder<List<ProductImagesDTO>> resp = productImageService.getProductImageByProductId(id);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PostMapping("/add")
    ResponseEntity<?> addProductImage(@RequestBody ProductImagesDTO productImagesDTO) {
        ResponseBuilder<ProductImagesDTO> resp = productImageService.addProductImage(productImagesDTO);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PutMapping("/update")
    ResponseEntity<?> updateProductImage( @RequestBody ProductImagesDTO productImagesDTO) {
        ResponseBuilder<ProductImagesDTO> resp = productImageService.updateProductImage(productImagesDTO);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteProductImage(@PathVariable Long id) {
        ResponseBuilder resp = productImageService.deleteProductImage(id);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
