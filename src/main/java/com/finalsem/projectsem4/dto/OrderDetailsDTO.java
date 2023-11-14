package com.finalsem.projectsem4.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;
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
public class OrderDetailsDTO extends AbstractDTO {
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal discount;
    private BigDecimal subTotal;
    private Long productId;
    private Long orderId;
}
