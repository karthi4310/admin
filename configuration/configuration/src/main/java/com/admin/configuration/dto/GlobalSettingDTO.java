package com.admin.configuration.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GlobalSettingDTO {

    @NotBlank(message = "Type cannot be blank")
    private String type;

    @NotNull(message = "Age cannot be null")
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 90, message = "Age must not exceed 90")
    private Integer age;

    @NotNull(message = "Education cannot be null")
    private String education;
}
