package com.finalsem.projectsem4.repository;

import com.finalsem.projectsem4.entity.Brands;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ly Quoc Trong
 */
@Repository
public interface BrandsRepository extends JpaRepository<Brands, Long> {
    Brands findByName(String name);
}
