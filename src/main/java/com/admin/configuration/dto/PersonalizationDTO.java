package com.admin.configuration.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PersonalizationDTO {

    @NotNull(message = "Farmer prefix cannot be null")
    @NotBlank(message = "Farmer prefix cannot be blank")
    private String farmerPrefix;

    @NotNull(message = "Farmer start number cannot be null")
    @NotBlank(message = "Farmer start number cannot be blank")
    private String farmerStartNo;

    @NotNull(message = "Employee prefix cannot be null")
    @NotBlank(message = "Employee prefix cannot be blank")
    private String employeePrefix;

    @NotNull(message = "Employee start number cannot be null")
    @NotBlank(message = "Employee start number cannot be blank")
    private String employeeStartNo;

    @NotNull(message = "Mail template module cannot be null")
    @NotBlank(message = "Mail template module cannot be blank")
    private String mailTemplateModule;

    @NotNull(message = "SMS template module cannot be null")
    @NotBlank(message = "SMS template module cannot be blank")
    private String smsTemplateModule;
}
