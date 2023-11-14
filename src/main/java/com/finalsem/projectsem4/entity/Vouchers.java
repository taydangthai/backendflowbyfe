package com.finalsem.projectsem4.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Ly Quoc Trong
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Vouchers extends BaseEntity {
    @Column(name = "voucher_code",nullable = false, length = 50)
    private String voucherCode;

    @Column(name = "discount_amount",nullable = false)
    private BigDecimal discountAmount;

    @Temporal(TemporalType.DATE)
    @Column(name = "expiry_date",nullable = false)
    private Date expiryDate;

    @Column(name = "usage_limit",nullable = false)
    private int usageLimit;

    @Column(name = "voucher_type",nullable = false, length = 50)
    private String voucherType;

    @Column(name = "products_eligible",nullable = false, length = 50000)
    @Lob
    private String productsEligible;

    @Column(name = "category_eligible",nullable = false, length = 50000)
    @Lob
    private String categoriesEligible;

    @Column(name = "min_purchase_amount",nullable = false)
    private BigDecimal minPurchaseAmount;

    @Column(name = "single_use",nullable = false)
    private boolean singleUse;
}
