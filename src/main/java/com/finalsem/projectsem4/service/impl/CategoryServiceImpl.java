package com.finalsem.projectsem4.service.impl;

import com.finalsem.projectsem4.common.DateTimeUtil;
import com.finalsem.projectsem4.common.ResponseBuilder;
import com.finalsem.projectsem4.dto.CategoryDTO;
import com.finalsem.projectsem4.entity.Categories;
import com.finalsem.projectsem4.repository.BrandsRepository;
import com.finalsem.projectsem4.repository.CategoryRepository;
import com.finalsem.projectsem4.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ly Quoc Trong
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    final
    BrandsRepository brandsRepository;

    public CategoryServiceImpl(CategoryRepository repository, BrandsRepository brandsRepository) {
        this.repository = repository;
        this.brandsRepository = brandsRepository;
    }

    @Override
    public ResponseBuilder<List<CategoryDTO>> getAllCategory() {
        List<Categories> categories = repository.findAll();
        List<CategoryDTO> result = categories.stream().map( category -> {
            CategoryDTO dto;
            ModelMapper mapper = new ModelMapper();
            dto = mapper.map(category, CategoryDTO.class);
            dto.setCreatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, category.getCreatedAt()));
            dto.setUpdatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, category.getUpdatedAt()));
            return dto;
        }).collect(Collectors.toList());
        return new ResponseBuilder<>("00", "success", result);
    }

    @Override
    public ResponseBuilder<CategoryDTO> getCategoryById(Long id) {
        Categories categories = repository.findById(id).orElse(null);
        CategoryDTO dto;
        ModelMapper mapper = new ModelMapper();
        dto = mapper.map(categories, CategoryDTO.class);
        dto.setCreatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, categories.getCreatedAt()));
        dto.setUpdatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, categories.getUpdatedAt()));
        return new ResponseBuilder<>("00", "success", dto);
    }

    @Override
    public ResponseBuilder<CategoryDTO> createCategory(CategoryDTO dto) {
        try {
            Categories categories;
            ModelMapper mapper = new ModelMapper();
            categories = mapper.map(dto, Categories.class);
            categories.setBrands(brandsRepository.getReferenceById(dto.getBrandId()));
            repository.save(categories);
            return new ResponseBuilder<>("00", "success");
        } catch (Exception e) {
            return new ResponseBuilder<>("01", e.toString());
        }
    }

    @Override
    public ResponseBuilder<CategoryDTO> updateCategory(Long id, CategoryDTO dto) {
        try {
            Categories categories = repository.findById(id).orElse(null);
            ModelMapper mapper = new ModelMapper();
            categories = mapper.map(dto, Categories.class);
            categories.setBrands(brandsRepository.getReferenceById(dto.getBrandId()));
            repository.save(categories);
            return new ResponseBuilder<>("00", "success");
        } catch (Exception e) {
            return new ResponseBuilder<>("01", e.toString());
        }
    }

    @Override
    public ResponseBuilder deleteCategory(Long id) {
        try {
            repository.deleteById(id);
            return new ResponseBuilder<>("00", "success");
        } catch (Exception e) {
            return new ResponseBuilder<>("01", e.toString());
        }
    }

    @Override
    public ResponseBuilder<List<CategoryDTO>> getCategoryByBrandId(Long id) {
        List<Categories> categories = repository.findAllByBrandsId(id);
        List<CategoryDTO> result = categories.stream().map( category -> {
            CategoryDTO dto;
            ModelMapper mapper = new ModelMapper();
            dto = mapper.map(category, CategoryDTO.class);
            dto.setCreatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, category.getCreatedAt()));
            dto.setUpdatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, category.getUpdatedAt()));
            return dto;
        }).collect(Collectors.toList());
        return new ResponseBuilder<>("00", "success", result);
    }
}
