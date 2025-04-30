package com.admin.configuration.controller;

import com.admin.configuration.dto.AdminConfigRequestDTO;
import com.admin.configuration.dto.AdminConfigResponseDTO;
import com.admin.configuration.service.AdminConfigService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/config")
@RequiredArgsConstructor
public class AdminConfigController {

    private final AdminConfigService adminConfigService;

    // Fetch all configuration data
    @GetMapping("/configuration")
    public ResponseEntity<AdminConfigResponseDTO> getAllConfiguration() {
        AdminConfigResponseDTO response = adminConfigService.getAllConfigurationData();
        return ResponseEntity.ok(response);
    }

    // Save new configuration data
    @PostMapping("/configuration")
    public ResponseEntity<String> saveConfiguration(@Valid @RequestBody AdminConfigRequestDTO requestDTO) {
        adminConfigService.saveConfigurationData(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Configuration data saved successfully.");
    }

    // Update existing configuration data
    @PutMapping("/configuration")
    public ResponseEntity<String> updateConfiguration(@Valid @RequestBody AdminConfigRequestDTO requestDTO) {
        adminConfigService.saveConfigurationData(requestDTO); // It could be a method for updating specifically
        return ResponseEntity.ok().body("Configuration data updated successfully.");
    }
}
