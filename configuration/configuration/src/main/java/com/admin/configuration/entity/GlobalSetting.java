package com.admin.configuration.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
    private String type; 

    @NotNull(message = "Age must not be null")
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 90, message = "Age must not exceed 90")
    private Integer age;

    @NotNull(message = "Education must not be null")
    @Size(min = 1, max = 100, message = "Education must be between 1 and 100 characters")
    private String education;  
}
