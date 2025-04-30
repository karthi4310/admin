package com.admin.configuration.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class GlobalSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Type must not be null")
    @Size(min = 1, max = 100, message = "Type must be between 1 and 100 characters")
    private String type;   // e.g., AGE_LIMIT, EDUCATION

    @NotNull(message = "Key must not be null")
    @Size(min = 1, max = 100, message = "Key must be between 1 and 100 characters")
    private String key;    // e.g., "Age", "Education Type"

    @NotNull(message = "Value must not be null")
    @Size(min = 1, max = 100, message = "Value must be between 1 and 100 characters")
    private String value;  // e.g., "18-60", "Graduation"
}
