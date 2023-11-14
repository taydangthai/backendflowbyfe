package com.finalsem.projectsem4.repository;

import com.finalsem.projectsem4.entity.Regions;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ly Quoc Trong
 */
public interface RegionRepository extends JpaRepository<Regions, Integer> {
}
