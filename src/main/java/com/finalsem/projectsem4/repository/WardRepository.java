package com.finalsem.projectsem4.repository;

import com.finalsem.projectsem4.entity.Wards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Ly Quoc Trong
 */
public interface WardRepository extends JpaRepository<Wards, String> {
    List<Wards> findAllByDistrictCode(String districtCode);

    List<Wards> findAllByUnitsId(Integer unitsId);
}
