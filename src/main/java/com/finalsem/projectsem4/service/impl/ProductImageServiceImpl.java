package com.finalsem.projectsem4.service.impl;

import com.finalsem.projectsem4.common.DateTimeUtil;
import com.finalsem.projectsem4.common.ResponseBuilder;
import com.finalsem.projectsem4.dto.ProductImagesDTO;
import com.finalsem.projectsem4.entity.ProductImages;
import com.finalsem.projectsem4.repository.ProductImagesRepository;
import com.finalsem.projectsem4.repository.ProductRepository;
import com.finalsem.projectsem4.service.ProductImageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ly Quoc Trong
 */
@Service
public class ProductImageServiceImpl implements ProductImageService {

    private final ProductRepository productRepository;

    private final ProductImagesRepository productImageRepository;

    public ProductImageServiceImpl(ProductRepository productRepository, ProductImagesRepository productImageRepository) {
        this.productRepository = productRepository;
        this.productImageRepository = productImageRepository;
    }

    @Override
    public ResponseBuilder<List<ProductImagesDTO>> getAllProductImage() {
        List<ProductImages> productImages = productImageRepository.findAll();
        List<ProductImagesDTO> productImagesDTOS = productImages.stream().map(productImage -> {
            ProductImagesDTO productImagesDTO;
            ModelMapper mapper = new ModelMapper();
            productImagesDTO = mapper.map(productImage, ProductImagesDTO.class);
            productImagesDTO.setCreatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, productImage.getCreatedAt()));
            productImagesDTO.setUpdatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, productImage.getUpdatedAt()));
            return productImagesDTO;
        }).collect(java.util.stream.Collectors.toList());
        return new ResponseBuilder<>("00", "success", productImagesDTOS);
    }

    @Override
    public ResponseBuilder<ProductImagesDTO> getProductImageById(Long id) {
        ProductImages productImages = productImageRepository.getReferenceById(id);
        ProductImagesDTO productImagesDTO;
        ModelMapper mapper = new ModelMapper();
        productImagesDTO = mapper.map(productImages, ProductImagesDTO.class);
        productImagesDTO.setCreatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, productImages.getCreatedAt()));
        productImagesDTO.setUpdatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, productImages.getUpdatedAt()));
        return new ResponseBuilder<>("00", "success", productImagesDTO);
    }

    @Override
    public ResponseBuilder<ProductImagesDTO> addProductImage(ProductImagesDTO dto) {
        try {
            ProductImages productImages = new ProductImages();
            ModelMapper mapper = new ModelMapper();
            productImages = mapper.map(dto, ProductImages.class);
            productImages.setProducts(productRepository.getReferenceById(dto.getProductId()));
            productImageRepository.save(productImages);
            return new ResponseBuilder<>("00", "success");
        } catch (Exception e) {
            return new ResponseBuilder<>("99", "fail");
        }
    }

    @Override
    public ResponseBuilder<ProductImagesDTO> updateProductImage(ProductImagesDTO dto) {
        try {
            ProductImages productImages = productImageRepository.getReferenceById(dto.getId());
            ModelMapper mapper = new ModelMapper();
            productImages = mapper.map(dto, ProductImages.class);
            productImages.setProducts(productRepository.getReferenceById(dto.getProductId()));
            productImageRepository.save(productImages);
            return new ResponseBuilder<>("00", "success");
        } catch (Exception e) {
            return new ResponseBuilder<>("99", "fail");
        }
    }

    @Override
    public ResponseBuilder deleteProductImage(Long id) {
        try {
            ProductImages productImages = productImageRepository.getReferenceById(id);
            productImageRepository.delete(productImages);
            return new ResponseBuilder<>("00", "success");
        } catch (Exception e) {
            return new ResponseBuilder<>("99", "fail");
        }
    }

    @Override
    public ResponseBuilder<List<ProductImagesDTO>> getProductImageByProductId(Long id) {
        List<ProductImages> productImages = productImageRepository.findAllByProductsId(id);
        List<ProductImagesDTO> productImagesDTOS = productImages.stream().map(productImage -> {
            ProductImagesDTO productImagesDTO;
            ModelMapper mapper = new ModelMapper();
            productImagesDTO = mapper.map(productImage, ProductImagesDTO.class);
            productImagesDTO.setCreatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, productImage.getCreatedAt()));
            productImagesDTO.setUpdatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, productImage.getUpdatedAt()));
            return productImagesDTO;
        }).collect(java.util.stream.Collectors.toList());
        return new ResponseBuilder<>("00", "success", productImagesDTOS);
    }
}
