package com.admin.configuration.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class LocationSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Country must not be null")
    @Size(min = 1, max = 100, message = "Country must be between 1 and 100 characters")
    private String country;

    @NotNull(message = "State must not be null")
    @Size(min = 1, max = 100, message = "State must be between 1 and 100 characters")
    private String state;

    @NotNull(message = "District must not be null")
    @Size(min = 1, max = 100, message = "District must be between 1 and 100 characters")
    private String district;

    @NotNull(message = "Block must not be null")
    @Size(min = 1, max = 100, message = "Block must be between 1 and 100 characters")
    private String block;

    @NotNull(message = "Village must not be null")
    @Size(min = 1, max = 100, message = "Village must be between 1 and 100 characters")
    private String village;

    @NotNull(message = "Zipcode must not be null")
    @Size(min = 4, max = 10, message = "Zipcode must be between 4 and 10 characters")
    private String zipcode;
}
