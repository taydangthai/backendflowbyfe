package com.finalsem.projectsem4.entity;

import lombok.Data;
import org.hibernate.annotations.Index;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Index(name = "idx_created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Index(name = "idx_updated_at")
    private Date updatedAt;

    @Column(name = "created_by")
    @CreatedBy
    @Index(name = "idx_created_by")
    private String createdBy;

    @Column(name = "updated_by")
    @LastModifiedBy
    @Index(name = "idx_updated_by")
    private String updatedBy;
}
