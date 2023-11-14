package com.finalsem.projectsem4.repository;

import com.finalsem.projectsem4.entity.Orders;
import com.finalsem.projectsem4.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    List<Orders> findAllByUsersId(Long id);
    Orders getReferenceById(Long id);
}
