package com.finalsem.projectsem4.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * @author silen
 */

@Data
//@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductFEDTO {
    private Long id;
    private Date createDate;
    private String sku;
    private String name;
    private String slug;
    private Long price;
    private Long discount;
    private Boolean featured;
    private Boolean newPro;
    private Long rating;
    private Long ratingCount;
    private Long saleCount;
    private List<String> category;
    private List<String> tag;
    private List<String> thumbImage;
    private List<String> image;
    private List<VariationFEDTO> variation;
    private String shortDescription;
    private String fullDescription;

    public ProductFEDTO() {
    }
}
