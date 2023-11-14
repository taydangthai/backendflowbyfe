package com.finalsem.projectsem4.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ly Quoc Trong
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "provinces")
public class Provinces {
    @Id
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name="name_en")
    private String nameEn;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "full_name_en")
    private String fullNameEn;

    @Column(name = "code_name")
    private String codeName;

    @OneToMany(mappedBy = "provinces")
    @JsonIgnore
    private List<Districts> districts = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE}, targetEntity = Units.class)
    @JoinColumn(name = "unit_id")
    private Units units;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE}, targetEntity = Regions.class)
    @JoinColumn(name = "region_id")
    private Regions regions;
}
