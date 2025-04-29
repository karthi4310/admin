package com.admin.configuration.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GlobalSettingDTO {

    @NotNull(message = "Type cannot be null")
    @NotBlank(message = "Type cannot be blank")
    private String type;

    @NotNull(message = "Key cannot be null")
    @NotBlank(message = "Key cannot be blank")
    private String key;

    @NotNull(message = "Value cannot be null")
    @NotBlank(message = "Value cannot be blank")
    private String value;
}
