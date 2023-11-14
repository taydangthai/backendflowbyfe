package com.finalsem.projectsem4.entity;

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
@Table(name = "regions")
public class Regions {
    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name="name_en")
    private String nameEn;

    @Column(name = "code_name")
    private String codeName;

    @Column(name = "code_name_en")
    private String codeNameEn;

    @OneToMany(mappedBy = "regions")
    private List<Provinces> provinces = new ArrayList<>();
}
