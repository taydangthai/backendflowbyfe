package com.finalsem.projectsem4.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ProductFE extends BaseEntity {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "sku")
    private String sku;

    @Column(name = "name")
    private String name;

    @Column(name = "slug")
    private String slug;

    @Column(name = "price")
    private Long price;

    @Column(name = "discount")
    private Long discount;

    @Column(name = "featured")
    private Boolean featured;

    @Column(name = "new_product")
    private Boolean newPro;

    @Column(name = "rating")
    private Long rating;

    @Column(name = "rating_count")
    private Long ratingCount;

    @Column(name = "sale_count")
    private Long saleCount;

    @ElementCollection
    @CollectionTable(name = "product_categories", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "category")
    private List<String> category;

    @ElementCollection
    @CollectionTable(name = "product_tags", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "tag")
    private List<String> tag;

    /*@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Variation> variations;*/

    @ElementCollection
    @CollectionTable(name = "product_thumb_images", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "thumb_image")
    private List<String> thumbImage;

    @ElementCollection
    @CollectionTable(name = "product_images", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "image")
    private List<String> image;

    @Column(name = "short_description", length = 1000)
    private String shortDescription;

    @Column(name = "full_description", length = 5000)
    private String fullDescription;
}
