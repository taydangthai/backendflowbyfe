package com.finalsem.projectsem4.repository;

import com.finalsem.projectsem4.entity.Products;
import com.finalsem.projectsem4.entity.Rating;
import com.finalsem.projectsem4.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ly Quoc Trong
 */
@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> getRatingByProductsId(Long id);

    List<Rating> getRatingByUsersId(Long id);

    List<Rating> getRatingByUsersIdAndProductsId(Long userId, Long productId);
}
