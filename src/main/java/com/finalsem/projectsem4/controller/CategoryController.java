package com.finalsem.projectsem4.controller;

import com.finalsem.projectsem4.common.ResponseBuilder;
import com.finalsem.projectsem4.dto.CategoryDTO;
import com.finalsem.projectsem4.service.CategoryService;
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
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping("/all")
    ResponseEntity<?> getAllCategories() {
        ResponseBuilder<List<CategoryDTO>> resp = service.getAllCategory();
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PostMapping("/create")
    ResponseEntity<?> addCategory(@RequestBody CategoryDTO dto) {
        ResponseBuilder<CategoryDTO> resp = service.createCategory(dto);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody CategoryDTO dto) {
        ResponseBuilder<CategoryDTO> resp = service.updateCategory(id, dto);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        ResponseBuilder resp = service.deleteCategory(id);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    ResponseEntity<?> getCategoryById(@PathVariable Long id) {
        ResponseBuilder<CategoryDTO> resp = service.getCategoryById(id);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/getByBrand/{id}")
    ResponseEntity<?> getCategoryByBrandId(@PathVariable Long id) {
        ResponseBuilder<List<CategoryDTO>> resp = service.getCategoryByBrandId(id);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
