package com.finalsem.projectsem4.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.finalsem.projectsem4.entity.Comments;
import com.finalsem.projectsem4.entity.ProductImages;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
    private Long variation;
    private Long thumbImage;
    private Long image;
    private String shortDescription;
    private String fullDescription;



    @JsonIgnore
    private List<ProductImagesDTO> pictures = new ArrayList<>();
    @JsonIgnore
    private List<CommentsDTO> comments = new ArrayList<>();
    @JsonIgnore
    private List<OrderDetailsDTO> orderDetails = new ArrayList<>();
    private Long categoryId;
    private Long brandId;
}
