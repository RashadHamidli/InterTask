package com.company.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //1.Admin, 2.Moderator
    @NotNull
    @NotBlank
    @Column(length = 500)
    private String name;

    @NotNull
    @Column(columnDefinition = "TIMESTAMP(0) DEFAULT now()")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP(0)")
    private LocalDateTime updatedAt;

    @NotNull
    @Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean status;

    private Long createdBy;

    private Long updatedBy;

    @ManyToMany(mappedBy = "userTypes", fetch = FetchType.LAZY)
    private List<Permission> permissions;

}
