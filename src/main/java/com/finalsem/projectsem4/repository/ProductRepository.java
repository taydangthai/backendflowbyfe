package com.finalsem.projectsem4.repository;

import com.finalsem.projectsem4.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
    Products getReferenceById(Long id);
    List<Products> findAllByCategoriesId(Long id);

    List<Products> findAllByBrandsId(Long id);
}
