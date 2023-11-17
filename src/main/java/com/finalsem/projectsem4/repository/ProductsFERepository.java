package com.finalsem.projectsem4.repository;

import com.finalsem.projectsem4.entity.ProductFE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductsFERepository extends JpaRepository<ProductFE, Long> {

    ProductFE findProductFESBySlug(String name);

}
