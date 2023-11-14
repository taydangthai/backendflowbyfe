package com.finalsem.projectsem4.repository;

import com.finalsem.projectsem4.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
    List<OrderDetails> findAllByOrdersId(Long id);
    List<OrderDetails> findAllByProductsId(Long id);
}
