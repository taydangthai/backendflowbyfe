package com.finalsem.projectsem4.controller;

import com.finalsem.projectsem4.common.ResponseBuilder;
import com.finalsem.projectsem4.dto.UsersDTO;
import com.finalsem.projectsem4.dto.authen.JwtResponse;
import com.finalsem.projectsem4.dto.authen.LoginRequest;
import com.finalsem.projectsem4.dto.authen.PasswordDTO;
import com.finalsem.projectsem4.dto.authen.SignupDTO;
import com.finalsem.projectsem4.security.service.UserDetailsImpl;
import com.finalsem.projectsem4.service.UsersService;
import com.finalsem.projectsem4.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ly Quoc Trong
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;
    private final UsersService userService;

    public UserController(UsersService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    ResponseEntity<?> getAllUsers() {
        ResponseBuilder<List<UsersDTO>> resp = userService.getAllUsers();
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    ResponseEntity<?> getUserById(@PathVariable Long id) {
        ResponseBuilder<UsersDTO> resp = userService.getUsersById(id);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        ResponseBuilder<JwtResponse> resp = userService.login(loginRequest);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PostMapping("/signup")
    ResponseEntity<?> registerUser(@Valid @RequestBody SignupDTO signupDTO) {
        ResponseBuilder<UsersDTO> resp = userService.createUsers(signupDTO);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PutMapping("/update")
    ResponseEntity<?> updateUser(@RequestBody UsersDTO usersDTO) {
        ResponseBuilder<UsersDTO> resp = userService.updateUsers(usersDTO);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PutMapping("/update-password")
    ResponseEntity<?> changePassword(@RequestBody PasswordDTO passwordDTO) {
        ResponseBuilder<?> resp = userService.changePassword(passwordDTO);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PostMapping("/forgot-password")
    ResponseEntity<?> forgotPassword(@RequestParam String email) {
        ResponseBuilder<?> resp = userService.forgotPassword(email);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteUser(@PathVariable Long id) {
        ResponseBuilder<?> resp = userService.deleteUsers(id);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> forgotPasswordUpdate(@RequestParam String token, @Valid @RequestBody PasswordDTO passForm) {
        ResponseBuilder<?> resp = userService.resetPassword(token, passForm);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
