package com.finalsem.projectsem4.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author silen
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO extends AbstractDTO {
    private String name;
    private String model;
    private String color;
    private Integer stockQuantity;
    private String description;
    private String technologyDescription;
    private BigDecimal originalPrice;
    private BigDecimal discount;
    private BigDecimal salePrice;
    @JsonIgnore
    private List<ProductImagesDTO> pictures = new ArrayList<>();
    @JsonIgnore
    private List<CommentsDTO> comments = new ArrayList<>();
    @JsonIgnore
    private List<OrderDetailsDTO> orderDetails = new ArrayList<>();
    private Long categoryId;
    private Long brandId;
}
