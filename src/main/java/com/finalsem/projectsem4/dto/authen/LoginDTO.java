package com.finalsem.projectsem4.dto.authen;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author silen
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginDTO {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
