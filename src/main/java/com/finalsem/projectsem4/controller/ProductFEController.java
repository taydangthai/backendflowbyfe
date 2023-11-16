package com.finalsem.projectsem4.controller;

import com.finalsem.projectsem4.common.ResponseBuilder;
import com.finalsem.projectsem4.dto.ProductDTO;
import com.finalsem.projectsem4.dto.ProductFEDTO;
import com.finalsem.projectsem4.service.ProductFEService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/product")
public class ProductFEController {
    @Autowired
    private ProductFEService feService;

    @GetMapping("/getListFE")
    ResponseEntity<?> getAllProducts() {
        ResponseBuilder<List<ProductFEDTO>> resp = feService.getListProduct();
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
