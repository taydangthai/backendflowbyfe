package com.finalsem.projectsem4.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ly Quoc Trong
 */
@Data
public class AbstractDTO {
    private Long id;
    private String createdAt;
    private String updatedAt;
    private String createdBy;
    private String updatedBy;
}
