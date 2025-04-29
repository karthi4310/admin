package com.admin.configuration.dto;

import com.admin.configuration.Enum.AccessType;
import com.admin.configuration.Enum.ModuleType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * DTO for transferring role configuration data.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {

    @NotNull(message = "Role name cannot be null")
    @NotBlank(message = "Role name cannot be blank")
    private String roleName;

    private String description;

    @NotNull(message = "Module types cannot be null")
    @NotEmpty(message = "At least one module type must be selected")
    private List<ModuleType> moduleTypes;

    private List<AccessType> accessTypes;
}
