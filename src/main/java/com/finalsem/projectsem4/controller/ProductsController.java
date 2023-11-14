package com.finalsem.projectsem4.controller;

import com.finalsem.projectsem4.common.ResponseBuilder;
import com.finalsem.projectsem4.dto.ProductDTO;
import com.finalsem.projectsem4.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ly Quoc Trong
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/products")
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    ResponseEntity<?> getAllProducts() {
        ResponseBuilder<List<ProductDTO>> resp = productService.getAllProduct();
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    ResponseEntity<?> getProductById(@PathVariable Long id) {
        ResponseBuilder<ProductDTO> resp = productService.getProductById(id);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/get/category/{id}")
    ResponseEntity<?> getProductByCategoryId(@PathVariable Long id) {
        ResponseBuilder<List<ProductDTO>> resp = productService.getProductByCategoryId(id);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/get/brand/{id}")
    ResponseEntity<?> getProductByBrandId(@PathVariable Long id) {
        ResponseBuilder<List<ProductDTO>> resp = productService.getProductByBrandId(id);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        ResponseBuilder resp = productService.deleteProduct(id);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PostMapping("/add")
    ResponseEntity<?> addProduct(@RequestBody ProductDTO productDTO) {
        ResponseBuilder<ProductDTO> resp = productService.addProduct(productDTO);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        ResponseBuilder<ProductDTO> resp = productService.updateProduct(id, productDTO);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
