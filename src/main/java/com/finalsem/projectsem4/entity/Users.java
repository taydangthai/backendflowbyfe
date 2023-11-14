package com.finalsem.projectsem4.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "user_name"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class Users extends BaseEntity {
    @Column(name = "user_name",length = 50, nullable = false)
    private String username;

    @Column(name = "full_name")
    private String fullName;

    @NotBlank(message = "Email cannot be blank")
    @Size(max = 100)
    @Column(name = "email",length = 100, nullable = false)
//    @Email(regexp=".*@.*\\..*", message = "Email should be valid")
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    // One customer can have multiple orders
    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Orders> orders = new ArrayList<>();

    @OneToMany(mappedBy = "users",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Comments> comments = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "users_id", referencedColumnName = "id" ),
            inverseJoinColumns = @JoinColumn(name = "roles_id", referencedColumnName = "id"))
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private Set<Roles> roles = new HashSet<>();

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private ForgotPassword forgotPasswords;

    @Column(name = "auth_provider")
    private String authProvider;
}
