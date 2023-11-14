package com.finalsem.projectsem4.repository;

import com.finalsem.projectsem4.entity.Districts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Ly Quoc Trong
 */
public interface DistrictRepository extends JpaRepository<Districts, String> {
    List<Districts> findAllByProvincesCode(String code);

    Districts findByCode(String code);

    List<Districts> findAllByUnitsId(Integer id);
}
