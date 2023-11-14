package com.finalsem.projectsem4.repository;

import com.finalsem.projectsem4.common.enums.ERoles;
import com.finalsem.projectsem4.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author silen
 */
@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
    Optional<Roles> findByName(ERoles name);
}
