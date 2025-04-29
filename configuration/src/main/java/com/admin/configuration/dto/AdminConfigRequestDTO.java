package com.admin.configuration.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminConfigRequestDTO {
    private List<UserDTO> users;
    private List<RoleDTO> roles;
    private List<PersonalizationDTO> personalization;
    private List<NotificationPreferenceDTO> notificationPreferences;
    private List<LocationSettingDTO> locationSettings;
    private List<GlobalSettingDTO> globalSettings;
    private List<CropSettingDTO> cropSettings;
}

