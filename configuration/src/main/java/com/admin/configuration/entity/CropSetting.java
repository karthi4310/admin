package com.admin.configuration.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class CropSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Crop feature must not be null")
    @Size(min = 1, max = 100, message = "Crop feature must be between 1 and 100 characters")
    private String cropFeature;

    @NotNull(message = "Crop variety must not be null")
    @Size(min = 1, max = 100, message = "Crop variety must be between 1 and 100 characters")
    private String cropVariety; // mapped to crop feature
}
