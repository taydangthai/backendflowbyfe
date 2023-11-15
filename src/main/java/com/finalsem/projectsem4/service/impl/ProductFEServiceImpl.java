package com.finalsem.projectsem4.service.impl;

import com.finalsem.projectsem4.common.ResponseBuilder;
import com.finalsem.projectsem4.dto.ProductFEDTO;
import com.finalsem.projectsem4.entity.ProductFE;
import com.finalsem.projectsem4.repository.ProductsFERepository;
import com.finalsem.projectsem4.service.ProductFEService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductFEServiceImpl implements ProductFEService {

    @Autowired
    private ProductsFERepository productsFERepository;
    @Override
    public ResponseBuilder<List<ProductFEDTO>> getListProduct() {
        List<ProductFE> productFES = productsFERepository.findAll();
        List<ProductFEDTO> productDTOS = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for (ProductFE productFE: productFES) {
            ProductFEDTO mapped = modelMapper.map(productFE, ProductFEDTO.class);
            productDTOS.add(mapped);
        }
        return new ResponseBuilder<>("00","success", productDTOS);
    }
}
