package com.company.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Column(unique = true)
    @Size(min = 5, max = 36)
    private String username;

    @NotNull(message = "password must not be null")
    @NotBlank(message = "password must not be empty")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$",
            message = "Password must contain at least 1 uppercase letter, 1 lowercase letter, and 1 digit, with a minimum length of 8 characters")
    private String password;

    @Size(min = 5, max = 36)
    private String name;

    @Size(min = 5, max = 36)
    private String surname;

    @Pattern(regexp = "^\\+(?:[0-9]●?){6,14}[0-9]$", message = "Phone number must be in valid format")
    private String phoneNumber;

    @Email
    @NotBlank(message = "email must not be empty")
    @NotNull(message = "email must not be null")
    @Column(unique = true)
    private String email;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_type_id")
    private UserType userType;

    @NotNull
    @Column(columnDefinition = "TIMESTAMP(0) DEFAULT now()")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP(0)")
    private LocalDateTime updatedAt;

    @NotNull
    @NotBlank
    @Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean status;

    private Long createdBy;

    private Long updatedBy;

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private List<Permission> permissions;

}



