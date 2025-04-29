package com.admin.configuration.entity;

import java.util.List;

import com.admin.configuration.Enum.AccessType;
import com.admin.configuration.Enum.ModuleType;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Role name must not be null")
    @Size(min = 2, max = 50, message = "Role name must be between 2 and 50 characters")
    private String roleName;

    @NotNull(message = "Description must not be null")
    @Size(min = 5, max = 200, message = "Description must be between 5 and 200 characters")
    private String description;

    @NotEmpty(message = "At least one module type must be selected")
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<ModuleType> moduleTypes;

    @NotEmpty(message = "At least one access type must be selected")
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<AccessType> accessTypes;
}
