package com.admin.configuration.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LocationSettingDTO {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "country cannot be null")
    private String country;
    @NotNull(message = "state cannot be null")
    private String state;
    @NotNull(message = "district cannot be null")
    private String district;
    @NotNull(message = "block cannot be null")
    private String block;
    @NotNull(message = "village cannot be null")
    private String village;
    @NotBlank(message = "Zipcode cannot be null")
    private String zipcode; // ID of the parent location for hierarchical mapping
}
