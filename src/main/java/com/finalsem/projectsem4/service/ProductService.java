package com.finalsem.projectsem4.service;

import com.finalsem.projectsem4.common.ResponseBuilder;
import com.finalsem.projectsem4.dto.ProductDTO;
import com.finalsem.projectsem4.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ProductService {

    ResponseBuilder<List<ProductDTO>> getAllProduct();

    ResponseBuilder<ProductDTO> addProduct(ProductDTO productDTO);

    ResponseBuilder<ProductDTO> updateProduct(Long id, ProductDTO productDTO);

    ResponseBuilder deleteProduct(Long id);

    ResponseBuilder<ProductDTO> getProductById(Long id);

    ResponseBuilder<List<ProductDTO>> getProductByCategoryId(Long id);

    ResponseBuilder<List<ProductDTO>> getProductByBrandId(Long id);

}
