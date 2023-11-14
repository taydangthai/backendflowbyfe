package com.finalsem.projectsem4.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Variation extends BaseEntity{

    @Column(name = "color")
    private String color;

    @Column(name = "color_code")
    private String colorCode;

    @Column(name = "image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductFE product;

    @OneToMany(mappedBy = "variation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SizeFE> size;
}
