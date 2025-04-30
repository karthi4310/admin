package com.admin.configuration.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "admin_user")  // Specifying the table name
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Username must not be null")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String username;

    @NotNull(message = "Email must not be null")
    @Email(message = "Invalid email format")
    @Size(max = 100, message = "Email must be less than or equal to 100 characters")
    private String email;

    @NotNull(message = "Role must not be null")
    @ManyToOne
    private Role role;

    private Boolean isNewUser = false;
}
