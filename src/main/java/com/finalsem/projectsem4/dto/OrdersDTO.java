package com.finalsem.projectsem4.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.finalsem.projectsem4.common.enums.Status;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrdersDTO extends AbstractDTO {
    private Status orderStatus;
    private BigDecimal totalAmount;
    private String shippingAddress;
    @JsonIgnore
    private List<OrderDetailsDTO> orderItems = new ArrayList<>();
    private Long userId;
}
