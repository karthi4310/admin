package com.admin.configuration.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CropSettingDTO {

    @NotNull(message = "Crop feature cannot be null")
    @NotBlank(message = "Crop feature cannot be blank")
    private String cropFeature;

    @NotNull(message = "Crop variety cannot be null")
    @NotBlank(message = "Crop variety cannot be blank")
    private String cropVariety;
}

