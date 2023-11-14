package com.finalsem.projectsem4.repository;

import com.finalsem.projectsem4.entity.Brands;
import com.finalsem.projectsem4.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ly Quoc Trong
 */
@Repository
public interface CategoryRepository extends JpaRepository<Categories, Long> {
    List<Categories> findAllByBrandsId(Long id);
}
