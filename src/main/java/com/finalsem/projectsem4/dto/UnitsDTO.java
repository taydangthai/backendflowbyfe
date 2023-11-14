package com.finalsem.projectsem4.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author Ly Quoc Trong
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UnitsDTO {
    private Integer id;
    private String fullName;
    private String fullNameEn;
    private String shortName;
    private String shortNameEn;
    private String codeName;
    private String codeNameEn;
}
