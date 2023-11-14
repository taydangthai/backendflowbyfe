package com.finalsem.projectsem4.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ly Quoc Trong
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BrandsDTO extends AbstractDTO {
    private String name;
    @JsonIgnore
    private List<CategoryDTO> categories = new ArrayList<>();
    @JsonIgnore
    private List<ProductDTO> products = new ArrayList<>();
}
