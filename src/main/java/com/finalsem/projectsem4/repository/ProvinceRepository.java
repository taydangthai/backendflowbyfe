package com.finalsem.projectsem4.repository;

import com.finalsem.projectsem4.entity.Provinces;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Ly Quoc Trong
 */
public interface ProvinceRepository extends JpaRepository<Provinces, String> {
    List<Provinces> findAllByRegionsId(Integer id);

    List<Provinces> findAllByUnitsId(Integer id);
}
