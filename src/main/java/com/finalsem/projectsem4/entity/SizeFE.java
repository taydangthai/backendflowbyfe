package com.finalsem.projectsem4.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SizeFE extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "stock")
    private int stock;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Variation variation;
}
