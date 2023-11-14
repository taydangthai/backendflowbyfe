package com.finalsem.projectsem4.service;

import com.finalsem.projectsem4.common.ResponseBuilder;
import com.finalsem.projectsem4.dto.CategoryDTO;

import java.util.List;

/**
 * @author Ly Quoc Trong
 */
public interface CategoryService {
    ResponseBuilder<List<CategoryDTO>> getAllCategory();

    ResponseBuilder<CategoryDTO> getCategoryById(Long id);

    ResponseBuilder<CategoryDTO> createCategory(CategoryDTO dto);

    ResponseBuilder<CategoryDTO> updateCategory(Long id, CategoryDTO dto);

    ResponseBuilder deleteCategory(Long id);

    ResponseBuilder<List<CategoryDTO>> getCategoryByBrandId(Long id);
}
