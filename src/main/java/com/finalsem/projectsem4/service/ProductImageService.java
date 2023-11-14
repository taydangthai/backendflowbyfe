package com.finalsem.projectsem4.service;

import com.finalsem.projectsem4.common.ResponseBuilder;
import com.finalsem.projectsem4.dto.ProductImagesDTO;

import java.util.List;

/**
 * @author Ly Quoc Trong
 */
public interface ProductImageService {
    ResponseBuilder<List<ProductImagesDTO>> getAllProductImage();

    ResponseBuilder<ProductImagesDTO> getProductImageById(Long id);

    ResponseBuilder<ProductImagesDTO> addProductImage(ProductImagesDTO dto);

    ResponseBuilder<ProductImagesDTO> updateProductImage(ProductImagesDTO dto);

    ResponseBuilder deleteProductImage(Long id);

    ResponseBuilder<List<ProductImagesDTO>> getProductImageByProductId(Long id);
}
