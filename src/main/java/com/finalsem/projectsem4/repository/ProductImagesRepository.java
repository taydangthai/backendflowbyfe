package com.finalsem.projectsem4.repository;

import com.finalsem.projectsem4.entity.ProductImages;
import com.finalsem.projectsem4.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ly Quoc Trong
 */
@Repository
public interface ProductImagesRepository extends JpaRepository<ProductImages, Long> {
    List<ProductImages> findAllByProductsId(Long id);
}
