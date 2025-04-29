package com.admin.configuration.service;

import com.admin.configuration.dto.AdminConfigRequestDTO;
import com.admin.configuration.dto.AdminConfigResponseDTO;
import com.admin.configuration.exception.ConfigurationValidationException;
import com.admin.configuration.mapper.AdminConfigMapper;
import com.admin.configuration.repository.*;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@RequiredArgsConstructor
@Validated
public class AdminConfigService {

    private static final Logger log = LoggerFactory.getLogger(AdminConfigService.class);

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PersonalizationRepository personalizationRepository;
    private final NotificationPreferenceRepository notificationPreferenceRepository;
    private final LocationSettingRepository locationSettingRepository;
    private final GlobalSettingRepository globalSettingRepository;
    private final CropSettingRepository cropSettingRepository;
    private final AdminConfigMapper mapper;

    /**
     * Aggregates all admin configuration data into a single response DTO.
     * 
     * @return AdminConfigResponseDTO containing configuration for users, roles,
     *         settings, and preferences.
     */
    public AdminConfigResponseDTO getAllConfigurationData() {
        log.info("Fetching all admin configuration data.");
        return mapper.mapToResponse(
            userRepository.findAll(),
            roleRepository.findAll(),
            personalizationRepository.findAll(),
            notificationPreferenceRepository.findAll(),
            locationSettingRepository.findAll(),
            globalSettingRepository.findAll(),
            cropSettingRepository.findAll()
        );
    }

    /**
     * Processes the configuration data sent via POST request and saves it to the database.
     * 
     * @param requestDTO the configuration data to be saved
     */
    @Transactional
    public void saveConfigurationData(@Valid AdminConfigRequestDTO requestDTO) {
        log.info("Saving admin configuration data.");
        validateConfigurationData(requestDTO);
        
        saveUsers(requestDTO);
        saveRoles(requestDTO);
        savePersonalization(requestDTO);
        saveNotificationPreferences(requestDTO);
        saveLocationSettings(requestDTO);
        saveGlobalSettings(requestDTO);
        saveCropSettings(requestDTO);
    }

    // Validate the incoming configuration data
    private void validateConfigurationData(AdminConfigRequestDTO requestDTO) {
        // Example validation check: Ensure that at least one user is provided
        if (requestDTO.getUsers() == null || requestDTO.getUsers().isEmpty()) {
            throw new ConfigurationValidationException("Users configuration is required.");
        }

        // Additional validation checks can be added here
        if (requestDTO.getRoles() == null || requestDTO.getRoles().isEmpty()) {
            throw new ConfigurationValidationException("Roles configuration is required.");
        }

        if (requestDTO.getPersonalization() == null || requestDTO.getPersonalization().isEmpty()) {
            throw new ConfigurationValidationException("Personalization configuration is required.");
        }

        // Add more checks for other configurations if necessary
    }

    private void saveUsers(AdminConfigRequestDTO requestDTO) {
        log.info("Saving users configuration...");
        if (requestDTO.getUsers() != null && !requestDTO.getUsers().isEmpty()) {
            userRepository.saveAll(mapper.mapToUserEntities(requestDTO.getUsers()));
        }
    }

    private void saveRoles(AdminConfigRequestDTO requestDTO) {
        log.info("Saving roles configuration...");
        if (requestDTO.getRoles() != null && !requestDTO.getRoles().isEmpty()) {
            roleRepository.saveAll(mapper.mapToRoleEntities(requestDTO.getRoles()));
        }
    }

    private void savePersonalization(AdminConfigRequestDTO requestDTO) {
        log.info("Saving personalization configuration...");
        if (requestDTO.getPersonalization() != null && !requestDTO.getPersonalization().isEmpty()) {
            personalizationRepository.saveAll(mapper.mapToPersonalizationEntities(requestDTO.getPersonalization()));
        }
    }

    private void saveNotificationPreferences(AdminConfigRequestDTO requestDTO) {
        log.info("Saving notification preferences configuration...");
        if (requestDTO.getNotificationPreferences() != null && !requestDTO.getNotificationPreferences().isEmpty()) {
            notificationPreferenceRepository.saveAll(mapper.mapToNotificationPreferenceEntities(requestDTO.getNotificationPreferences()));
        }
    }

    private void saveLocationSettings(AdminConfigRequestDTO requestDTO) {
        log.info("Saving location settings configuration...");
        if (requestDTO.getLocationSettings() != null && !requestDTO.getLocationSettings().isEmpty()) {
            locationSettingRepository.saveAll(mapper.mapToLocationSettingEntities(requestDTO.getLocationSettings()));
        }
    }

    private void saveGlobalSettings(AdminConfigRequestDTO requestDTO) {
        log.info("Saving global settings configuration...");
        if (requestDTO.getGlobalSettings() != null && !requestDTO.getGlobalSettings().isEmpty()) {
            globalSettingRepository.saveAll(mapper.mapToGlobalSettingEntities(requestDTO.getGlobalSettings()));
        }
    }

    private void saveCropSettings(AdminConfigRequestDTO requestDTO) {
        log.info("Saving crop settings configuration...");
        if (requestDTO.getCropSettings() != null && !requestDTO.getCropSettings().isEmpty()) {
            cropSettingRepository.saveAll(mapper.mapToCropSettingEntities(requestDTO.getCropSettings()));
        }
    }
}
