package com.company.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "blog_image")
public class BlogImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String filePath;

    @Column(length = 500)
    private String altText;

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

    @ManyToOne
    @JoinColumn(name = "blog_id", nullable = false)
    private Blog blog;
}
