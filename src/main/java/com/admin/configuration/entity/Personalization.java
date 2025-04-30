package com.admin.configuration.entity;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Data
@Entity
public class Personalization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Farmer code settings
    @NotNull(message = "Farmer prefix is required")
    @Column(nullable = false)
    private String farmerPrefix;

    @NotNull(message = "Farmer start number is required")
    @Column(nullable = false)
    private String farmerStartNo;

    // Employee code settings
    @NotNull(message = "Employee prefix is required")
    @Column(nullable = false)
    private String employeePrefix;

    @NotNull(message = "Employee start number is required")
    @Column(nullable = false)
    private String employeeStartNo;

    // Module for mail templates
    @NotNull(message = "Mail template module is required")
    @Column(nullable = false)
    private String mailTemplateModule;

    // Module for SMS templates
    @NotNull(message = "SMS template module is required")
    @Column(nullable = false)
    private String smsTemplateModule;
}
