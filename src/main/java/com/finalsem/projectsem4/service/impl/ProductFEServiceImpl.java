package com.finalsem.projectsem4.service.impl;

import com.finalsem.projectsem4.common.ResponseBuilder;
import com.finalsem.projectsem4.dto.ProductDTO;
import com.finalsem.projectsem4.dto.ProductFEDTO;
import com.finalsem.projectsem4.dto.VariationFEDTO;
import com.finalsem.projectsem4.entity.*;
import com.finalsem.projectsem4.mapper.EntityToDTOMapper;
import com.finalsem.projectsem4.repository.ProductsFERepository;
import com.finalsem.projectsem4.service.ProductFEService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductFEServiceImpl implements ProductFEService {

    @Autowired
    private ProductsFERepository productsFERepository;
    @Override
    public ResponseBuilder<List<ProductFEDTO>> getListProduct() {
        List<ProductFE> productFES = productsFERepository.findAll();
        List<ProductFEDTO> productDTOS = new ArrayList<>();
        for (ProductFE productFE: productFES) {
            ProductFEDTO productFEDTO = new ProductFEDTO();
            productFEDTO.setId(productFE.getId());
            productFEDTO.setCreateDate(productFE.getCreateDate());
            productFEDTO.setSku(productFE.getSku());
            productFEDTO.setName(productFE.getName());
            productFEDTO.setSlug(productFE.getSlug());
            productFEDTO.setPrice(productFE.getPrice());
            productFEDTO.setDiscount(productFE.getDiscount());
            productFEDTO.setFeatured(productFE.getFeatured());
            productFEDTO.setNewPro(productFE.getNewPro());
            productFEDTO.setRating(productFE.getRating());
            productFEDTO.setRatingCount(productFE.getRatingCount());
            productFEDTO.setSaleCount(productFE.getSaleCount());
            productFEDTO.setShortDescription(productFE.getShortDescription());
            productFEDTO.setFullDescription(productFE.getFullDescription());
            List<String> stringCategoryList = productFE.getCategory().stream()
                    .map(CategoryFE::getName)
                    .collect(Collectors.toList());
            List<String> stringTagList = productFE.getTag().stream()
                    .map(TagFE::getName)
                    .collect(Collectors.toList());
            List<String> stringThumbImageList = productFE.getThumbImage().stream()
                    .map(ThumbImageFE::getUrl)
                    .collect(Collectors.toList());
            List<String> stringImageList = productFE.getImage().stream()
                    .map(ImageFE::getUrl)
                    .collect(Collectors.toList());
            List<VariationFEDTO> fedtoList = productFE.getVariationFES().stream()
                    .map(EntityToDTOMapper::mapVariationToDTO)
                    .collect(Collectors.toList());
            productFEDTO.setVariation(fedtoList);
            productFEDTO.setCategory(stringCategoryList);
            productFEDTO.setTag(stringTagList);
            productFEDTO.setThumbImage(stringThumbImageList);
            productFEDTO.setImage(stringImageList);
            productDTOS.add(productFEDTO);
        }
        return new ResponseBuilder<>("00","success", productDTOS);
    }

    @Override
    public ResponseBuilder<ProductFEDTO> getProductByName(String name) {
        ProductFE productFE = productsFERepository.findProductFESBySlug(name);
        ProductFEDTO fedto = new ProductFEDTO();
        fedto.setId(productFE.getId());
        fedto.setCreateDate(productFE.getCreateDate());
        fedto.setSku(productFE.getSku());
        fedto.setName(productFE.getName());
        fedto.setSlug(productFE.getSlug());
        fedto.setPrice(productFE.getPrice());
        fedto.setDiscount(productFE.getDiscount());
        fedto.setFeatured(productFE.getFeatured());
        fedto.setNewPro(productFE.getNewPro());
        fedto.setRating(productFE.getRating());
        fedto.setRatingCount(productFE.getRatingCount());
        fedto.setSaleCount(productFE.getSaleCount());
        fedto.setShortDescription(productFE.getShortDescription());
        fedto.setFullDescription(productFE.getFullDescription());
        List<String> stringCategoryList = productFE.getCategory().stream()
                .map(CategoryFE::getName)
                .collect(Collectors.toList());
        List<String> stringTagList = productFE.getTag().stream()
                .map(TagFE::getName)
                .collect(Collectors.toList());
        List<String> stringThumbImageList = productFE.getThumbImage().stream()
                .map(ThumbImageFE::getUrl)
                .collect(Collectors.toList());
        List<String> stringImageList = productFE.getImage().stream()
                .map(ImageFE::getUrl)
                .collect(Collectors.toList());
        List<VariationFEDTO> fedtoList = productFE.getVariationFES().stream()
                .map(EntityToDTOMapper::mapVariationToDTO)
                .collect(Collectors.toList());
        fedto.setVariation(fedtoList);
        fedto.setCategory(stringCategoryList);
        fedto.setTag(stringTagList);
        fedto.setThumbImage(stringThumbImageList);
        fedto.setImage(stringImageList);
        return new ResponseBuilder<>("","", fedto);
    }
}
