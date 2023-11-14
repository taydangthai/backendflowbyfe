package com.finalsem.projectsem4.service.impl;

import com.finalsem.projectsem4.common.ResponseBuilder;
import com.finalsem.projectsem4.common.enums.ERoles;
import com.finalsem.projectsem4.dto.UsersDTO;
import com.finalsem.projectsem4.dto.authen.*;
import com.finalsem.projectsem4.entity.ForgotPassword;
import com.finalsem.projectsem4.entity.Roles;
import com.finalsem.projectsem4.entity.Users;
import com.finalsem.projectsem4.repository.ForgetPasswordRepository;
import com.finalsem.projectsem4.repository.RolesRepository;
import com.finalsem.projectsem4.repository.UsersRepository;
import com.finalsem.projectsem4.security.service.UserDetailsImpl;
import com.finalsem.projectsem4.service.MailService;
import com.finalsem.projectsem4.service.UsersService;
import com.finalsem.projectsem4.util.JwtUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Ly Quoc Trong
 */
@Service
public class UserServiceImpl implements UsersService {

    @Autowired
    private  RolesRepository roleRepository;

    @Autowired
    private  AuthenticationManager authenticationManager;

    @Autowired
    private  PasswordEncoder encoder;

    @Autowired
    private  UsersRepository usersRepository;

    @Autowired
    private  JwtUtils jwtUtils;

    @Autowired
    private  ForgetPasswordRepository forgetPasswordRepository;

    @Autowired
    private  MailService mailService;

    @Override
    public ResponseBuilder<List<UsersDTO>> getAllUsers() {
        return null;
    }

    @Override
    public ResponseBuilder<UsersDTO> getUsersById(Long id) {
        Users users = usersRepository.getReferenceById(id);
        UsersDTO usersDTO;
        ModelMapper modelMapper = new ModelMapper();
        usersDTO = modelMapper.map(users, UsersDTO.class);
        return new ResponseBuilder<>("00", "Success", usersDTO);
    }

    @Override
    public ResponseBuilder<UsersDTO> createUsers(SignupDTO dto) {
        if (usersRepository.existsByUsername(dto.getUsername())) {
            return new ResponseBuilder<>("99", "Username is already taken!");
        }
        if (usersRepository.existsByEmail(dto.getEmail())) {
            return new ResponseBuilder<>("99", "Email is already in use!");
        }
        if (usersRepository.existsByPhone(dto.getPhone())) {
            return new ResponseBuilder<>("99", "Phone is already in use!");
        }
        Users users = Users.builder()
                .username(dto.getUsername())
                .password(encoder.encode(dto.getPassword()))
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .fullName(dto.getFullName())
                .address(dto.getAddress())
                .build();
        Set<String> strRoles = dto.getRoles();
        Set<Roles> roles = new HashSet<>();
        if(strRoles == null){
            Roles role = roleRepository.findByName(ERoles.ROLE_USER).
                    orElseThrow(() -> new RuntimeException("Error: Role not found"));
            roles.add(role);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Roles adminRole = roleRepository.findByName(ERoles.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role not found"));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Roles modRole = roleRepository.findByName(ERoles.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role not found"));
                        roles.add(modRole);

                        break;
                    default:
                        Roles userRole = roleRepository.findByName(ERoles.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role not found"));
                        roles.add(userRole);
                }
            });
        }
        users.setRoles(roles);
        usersRepository.save(users);
        return new ResponseBuilder<>("00", "User registered successfully");
    }

    @Override
    public ResponseBuilder<UsersDTO> updateUsers(UsersDTO dto) {
        return null;
    }

    @Override
    public ResponseBuilder<UsersDTO> deleteUsers(Long id) {
        try {
            usersRepository.deleteById(id);
            return new ResponseBuilder<>("00", "Success");
        } catch (Exception e) {
            return new ResponseBuilder<>("99", "Error");
        }
    }

    @Override
    public ResponseBuilder<JwtResponse> login(LoginRequest loginDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDTO.getUsername(),
                            loginDTO.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());
            return new ResponseBuilder<>("00", "successfully",
                    new JwtResponse(jwt, roles, userDetails.getUserId(), userDetails.getUsername()));
        } catch (Exception e) {
            return new ResponseBuilder<>("01","username or password invalid");
        }
    }

    @Override
    public ResponseBuilder<?> changePassword(PasswordDTO passwordDTO) {
        Users users = usersRepository.findByUsername(passwordDTO.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + passwordDTO.getUsername()));
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(passwordDTO.getUsername(), passwordDTO.getCurrentPassword()));
            users.setPassword(encoder.encode(passwordDTO.getNewPassword()));
            usersRepository.save(users);
            return new ResponseBuilder<>("00", "Change password successfully");
        } catch (Exception e) {
            throw new RuntimeException("Change password failed with error: " + e.getMessage());
        }
    }

    @Override
    public ResponseBuilder<?> forgotPassword(String email) {
        Users user = usersRepository.findByEmail(email);
        ForgotPassword token;
        if (user == null) {
            return  new ResponseBuilder<>("01","Invalid email id.");
        }
        if (user.getForgotPasswords() != null) {
            token = user.getForgotPasswords();
        } else {
            token = new ForgotPassword();
        }
        token.setUser(user);
        token.setToken(UUID.randomUUID().toString());
        token.setTokenCreationDate(LocalDateTime.now());
        forgetPasswordRepository.save(token);
        user.setForgotPasswords(token);
        usersRepository.save(user);
        String response = token.getToken();

        if (!response.startsWith("Invalid")) {
            response = "/api/users/reset-password?token=" + response;
        }
        mailService.sendmail(email, response);
        return new ResponseBuilder<>("00", "Success sent to email", response);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return UsersDTO.build(user);
    }

    @Override
    public ResponseBuilder<?> resetPassword(String token, PasswordDTO passForm) {
        ForgotPassword forgotPassword = forgetPasswordRepository.findByToken(token);
        Users user = forgotPassword.getUser();
        if (user == null) {
            return new ResponseBuilder<>("01","Not found user");
        }
        try {
            user.setPassword(encoder.encode(passForm.getNewPassword()));
            usersRepository.save(user);
            return new ResponseBuilder<>("00","Success");

        } catch (Exception e) {
            throw new RuntimeException("Fail!");
        }
    }

    @Override
    public ResponseBuilder<?> getUserInfo(String id) {
        Optional<Users> optionalUser  = usersRepository.findByUsername(id);
        Users user;
        if (optionalUser.isEmpty()) {
            user = new Users();
            user.setUsername(id);
            usersRepository.save(user);
        } else {
            user = optionalUser.get();
        }
        UsersDTO userDTO = new UsersDTO();
        return new ResponseBuilder<>("00","", userDTO);
    }
}
