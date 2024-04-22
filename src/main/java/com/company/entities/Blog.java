package com.company.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "blog")
@Data
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "name must not be null")
    @NotBlank(message = "name must not be empty")
    @Column(length = 500)
    private String name;

    @NotNull(message = "title must not be null")
    @NotBlank(message = "name must not be empty")
    @Column(length = 500)
    private String title;

    @NotNull(message = "text must not be null")
    @NotBlank(message = "text must not be empty")
    @Column(columnDefinition = "TEXT")
    private String content;

    @NotNull(message = "cover must not be null")
    @NotBlank(message = "cover must not be empty")
    @Column(length = 500)
    private String cover;

    @NotNull
    private Long viewedCount;

    @NotNull
    private boolean published;

    @NotNull
    @Column(columnDefinition = "TIMESTAMP(0)")
    private LocalDateTime publishedDate;

    @NotNull
    @Column(columnDefinition = "TIMESTAMP(0)")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP(0)")
    private LocalDateTime updatedAt;

    @NotNull
    @Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean status;

    private Long createdBy;

    private Long updatedBy;

    @OneToMany(mappedBy = "blog")
    private List<BlogImage> blogImages;

}
