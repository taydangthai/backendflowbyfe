package com.finalsem.projectsem4.service;

import com.finalsem.projectsem4.common.ResponseBuilder;
import com.finalsem.projectsem4.dto.UsersDTO;
import com.finalsem.projectsem4.dto.authen.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * @author Ly Quoc Trong
 */
public interface UsersService {
    ResponseBuilder<List<UsersDTO>> getAllUsers();

    ResponseBuilder<UsersDTO> getUsersById(Long id);

    ResponseBuilder<UsersDTO> createUsers(SignupDTO dto);

    ResponseBuilder<UsersDTO> updateUsers(UsersDTO dto);

    ResponseBuilder<UsersDTO> deleteUsers(Long id);

    ResponseBuilder<JwtResponse> login(LoginRequest loginDTO);

    ResponseBuilder<?> changePassword(PasswordDTO passwordDTO);

    ResponseBuilder<?> forgotPassword(String email);

    UserDetails loadUserByUsername(String username);

    ResponseBuilder<?> resetPassword(String token, PasswordDTO passForm);

    ResponseBuilder<?> getUserInfo(String id);
}
