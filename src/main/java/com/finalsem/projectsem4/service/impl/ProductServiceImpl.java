package com.finalsem.projectsem4.service.impl;

import com.finalsem.projectsem4.common.DateTimeUtil;
import com.finalsem.projectsem4.common.ResponseBuilder;
import com.finalsem.projectsem4.dto.ProductDTO;
import com.finalsem.projectsem4.dto.ProductImagesDTO;
import com.finalsem.projectsem4.entity.ProductImages;
import com.finalsem.projectsem4.entity.Products;
import com.finalsem.projectsem4.repository.ProductImagesRepository;
import com.finalsem.projectsem4.repository.ProductRepository;
import com.finalsem.projectsem4.service.ProductImageService;
import com.finalsem.projectsem4.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Ly Quoc Trong
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductImageService productImageService;
    private final ProductRepository productRepository;
    private final ProductImagesRepository productImageRepository;

    public ProductServiceImpl(ProductRepository productRepository, ProductImagesRepository productImageRepository, ProductImageService productImageService) {
        this.productRepository = productRepository;
        this.productImageRepository = productImageRepository;
        this.productImageService = productImageService;
    }

    @Override
    public ResponseBuilder<List<ProductDTO>> getAllProduct() {
        List<Products> products = productRepository.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for (Products product : products) {
            ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
            productDTO.setCreatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, product.getCreatedAt()));
            productDTO.setUpdatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, product.getUpdatedAt()));
            productDTOS.add(productDTO);
        }
        return new ResponseBuilder<>("00", "success", productDTOS);
    }

    @Override
    public ResponseBuilder<ProductDTO> addProduct(ProductDTO productDTO) {
        Products products;
        ModelMapper mapper = new ModelMapper();
        products = mapper.map(productDTO, Products.class);
        productRepository.save(products);
        for (ProductImagesDTO imageDTO : productDTO.getPictures()) {
            productImageService.addProductImage(imageDTO);
        }
        return new ResponseBuilder<>("00", "success");
    }

    @Override
    public ResponseBuilder<ProductDTO> updateProduct(Long id, ProductDTO productDTO) {
        Products product = productRepository.getReferenceById(id);
        ModelMapper mapper = new ModelMapper();
        product = mapper.map(productDTO, Products.class);
        productRepository.save(product);
        for (ProductImagesDTO imageDTO : productDTO.getPictures()) {
            productImageService.updateProductImage(imageDTO);
        }
        return new ResponseBuilder<>("00", "success");
    }

    @Override
    public ResponseBuilder deleteProduct(Long id) {
        try {
            Products product = productRepository.getReferenceById(id);
            ProductDTO productDTO;
            ModelMapper mapper = new ModelMapper();
            productDTO = mapper.map(product, ProductDTO.class);
            for (ProductImagesDTO imageDTO : productDTO.getPictures()) {
                productImageRepository.deleteById(imageDTO.getId());
            }
            productRepository.deleteById(id);
            return new ResponseBuilder<>("00", "success");
        } catch (Exception e) {
            return new ResponseBuilder<>("99", "fail");
        }
    }

    @Override
    public ResponseBuilder<ProductDTO> getProductById(Long id) {
        Products product = productRepository.getReferenceById(id);
        ProductDTO productDTO;
        ModelMapper mapper = new ModelMapper();
        productDTO = mapper.map(product, ProductDTO.class);
        productDTO.setCreatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, product.getCreatedAt()));
        productDTO.setUpdatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, product.getUpdatedAt()));
        return new ResponseBuilder<>("00", "success", productDTO);
    }

    @Override
    public ResponseBuilder<List<ProductDTO>> getProductByCategoryId(Long id) {
        List<Products> products = productRepository.findAllByCategoriesId(id);
        List<ProductDTO> productDTOs = products.stream().map(product -> {
            ModelMapper mapper = new ModelMapper();
            ProductDTO productDTO = mapper.map(product, ProductDTO.class);
            productDTO.setCreatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, product.getCreatedAt()));
            productDTO.setUpdatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, product.getUpdatedAt()));
            return productDTO;
        }).collect(Collectors.toList());
        return new ResponseBuilder<>("00", "success", productDTOs);
    }

    @Override
    public ResponseBuilder<List<ProductDTO>> getProductByBrandId(Long id) {
        List<Products> products = productRepository.findAllByBrandsId(id);
        List<ProductDTO> productDTOs = products.stream().map(product -> {
            ModelMapper mapper = new ModelMapper();
            ProductDTO productDTO = mapper.map(product, ProductDTO.class);
            productDTO.setCreatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, product.getCreatedAt()));
            productDTO.setUpdatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, product.getUpdatedAt()));
            return productDTO;
        }).collect(Collectors.toList());
        return new ResponseBuilder<>("00", "success", productDTOs);
    }

}
