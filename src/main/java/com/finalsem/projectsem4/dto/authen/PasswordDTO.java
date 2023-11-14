package com.finalsem.projectsem4.dto.authen;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author Ly Quoc Trong
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PasswordDTO {
    private Long id;

    @Size(min = 3 , max = 50)
    private String username;

    @Size(min = 6 ,max = 100)
    private String currentPassword;

    @Size(min = 6 ,max = 100)
    private String newPassword;
}
