package com.finalsem.projectsem4.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

/**
 * @author Ly Quoc Trong
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VouchersDTO extends AbstractDTO {
    private String voucherCode;
    private String discountAmount;
    private String expiryDate;
    private String usageLimit;
    private String voucherType;
    private String productsEligible;
    private String categoriesEligible;
    private String minPurchaseAmount;
    private String singleUse;
}
