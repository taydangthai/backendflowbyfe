package com.finalsem.projectsem4.dto.authen;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Ly Quoc Trong
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {
    private Long userId;
    private String token;
    private String type = "Bearer";
    private List<String> roles;
    private String username;

    public JwtResponse(String token, List<String> roles, Long userId,  String username) {

        this.token = token;
        this.roles = roles;
        this.userId = userId;
        this.username = username;
    }
}
