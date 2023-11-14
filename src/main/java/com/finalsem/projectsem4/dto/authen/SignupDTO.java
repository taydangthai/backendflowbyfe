package com.finalsem.projectsem4.dto.authen;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * @author silen
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SignupDTO {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    private String fullName;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    private String phone;

    private String address;

    private Set<String> roles;

    @NotBlank
    @Size(min = 3, max = 40)
    private String password;
}
