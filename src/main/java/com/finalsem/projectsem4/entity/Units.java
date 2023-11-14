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
@Table(name = "units")
public class Units {
    @Id
    private Integer id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name="full_name_en")
    private String fullNameEn;

    @Column(name = "short_name")
    private String shortName;

    @Column(name="short_name_en")
    private String shortNameEn;

    @Column(name = "code_name")
    private String codeName;

    @Column(name = "code_name_en")
    private String codeNameEn;

    @OneToMany(mappedBy = "units")
    private List<Provinces> provinces = new ArrayList<>();

    @OneToMany(mappedBy = "units")
    private List<Wards> wards = new ArrayList<>();

    @OneToMany(mappedBy = "units")
    private List<Districts> districts = new ArrayList<>();
}
