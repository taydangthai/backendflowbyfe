package com.finalsem.projectsem4.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finalsem.projectsem4.common.enums.ERoles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
//@AllArgsConstructor
//@NoArgsConstructor
public class Roles extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "role_name",nullable = false)
    private ERoles name;

//    @ManyToMany(mappedBy = "roles")
//    @JsonIgnore
//    Set<Users> users = new HashSet<Users>();

}
