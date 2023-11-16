package com.finalsem.projectsem4.controller;

import com.finalsem.projectsem4.common.ResponseBuilder;
import com.finalsem.projectsem4.dto.ProductDTO;
import com.finalsem.projectsem4.dto.ProductFEDTO;
import com.finalsem.projectsem4.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Ly Quoc Trong
 */
@Log4j2
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

    /*@GetMapping("/getList")
    ResponseEntity<?> getAllProductsFE() {
        ResponseBuilder<List<ProductFEDTO>> resp = new ResponseBuilder<>(null,null,null);
        List<ProductFEDTO> list = Arrays.asList(new ProductFEDTO(
                new Date("Mar 11 2020 10:01:00 AM"),
                "01",
                "Lorem ipsum fashion one",
                "lorem-ipsum-fashion-one",
                17L,
                10L,
                true,
                true,
                4L,
                5L,
                90L,
                Arrays.asList("fashion", "women"),
                Arrays.asList("fashion", "women"),
                Arrays.asList(
                        "/assets/images/product/fashion/1.jpg",
                        "/assets/images/product/fashion/2.jpg"
                ),
                Arrays.asList(
                        "/assets/images/product/fashion/1.jpg",
                        "/assets/images/product/fashion/2.jpg",
                        "/assets/images/product/fashion/3.jpg",
                        "/assets/images/product/fashion/4.jpg",
                        "/assets/images/product/fashion/5.jpg"
                ),
                "Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem.",
                "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt."
        ),
                new ProductFEDTO(
                        new Date("Mar 11 2020 10:01:00 AM"),
                        "02",
                        "Lorem ipsum fashion one",
                        "lorem-ipsum-fashion-one",
                        17L,
                        10L,
                        true,
                        true,
                        4L,
                        5L,
                        90L,
                        Arrays.asList("fashion", "women"),
                        Arrays.asList("fashion", "women"),
                        Arrays.asList(
                                "/assets/images/product/fashion/1.jpg",
                                "/assets/images/product/fashion/2.jpg"
                        ),
                        Arrays.asList(
                                "/assets/images/product/fashion/1.jpg",
                                "/assets/images/product/fashion/2.jpg",
                                "/assets/images/product/fashion/3.jpg",
                                "/assets/images/product/fashion/4.jpg",
                                "/assets/images/product/fashion/5.jpg"
                        ),
                        "Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem.",
                        "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt."
                ),
                new ProductFEDTO(
                        new Date("Mar 11 2020 10:01:00 AM"),
                        "03",
                        "Lorem ipsum fashion one",
                        "lorem-ipsum-fashion-one",
                        17L,
                        10L,
                        true,
                        true,
                        4L,
                        5L,
                        90L,
                        Arrays.asList("fashion", "women"),
                        Arrays.asList("fashion", "women"),
                        Arrays.asList(
                                "/assets/images/product/fashion/1.jpg",
                                "/assets/images/product/fashion/2.jpg"
                        ),
                        Arrays.asList(
                                "/assets/images/product/fashion/1.jpg",
                                "/assets/images/product/fashion/2.jpg",
                                "/assets/images/product/fashion/3.jpg",
                                "/assets/images/product/fashion/4.jpg",
                                "/assets/images/product/fashion/5.jpg"
                        ),
                        "Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem.",
                        "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt."
                )

        );
        resp.setData(list);
        log.info(resp.getData().toString());
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }*/
}
