package com.finalsem.projectsem4.repository;

import com.finalsem.projectsem4.entity.ForgotPassword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForgetPasswordRepository extends JpaRepository<ForgotPassword, Long> {
    ForgotPassword findByToken(String token);
}
