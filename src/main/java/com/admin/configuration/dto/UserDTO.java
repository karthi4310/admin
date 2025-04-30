package com.admin.configuration.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for transferring user configuration data.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @NotNull(message = "Username cannot be null")
    @NotBlank(message = "Username cannot be blank")
    private String username;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Role ID cannot be null")
    private Long roleId; // Refers to the Role entity's ID

    @NotNull(message = "New User flag cannot be null")
    private Boolean isNewUser = Boolean.FALSE; // Default to false if not provided
}
