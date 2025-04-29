package com.admin.configuration.mapper;

import com.admin.configuration.dto.*;
import com.admin.configuration.entity.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AdminConfigMapper {

    // DTO to Entity mapping methods

    public List<User> mapToUserEntities(List<UserDTO> userDTOs) {
        return userDTOs.stream().map(dto -> {
            User user = new User();
            user.setUsername(dto.getUsername());
            user.setEmail(dto.getEmail());
            // Set other properties from DTO to Entity as necessary
            user.setIsNewUser(dto.getIsNewUser());
            return user;
        }).collect(Collectors.toList());
    }

    public List<Role> mapToRoleEntities(List<RoleDTO> roleDTOs) {
        return roleDTOs.stream().map(dto -> {
            Role role = new Role();
            role.setRoleName(dto.getRoleName());
            role.setDescription(dto.getDescription());
            // Ensure ModuleTypes and AccessTypes are not null
            role.setModuleTypes(dto.getModuleTypes() != null ? dto.getModuleTypes() : List.of());
            role.setAccessTypes(dto.getAccessTypes() != null ? dto.getAccessTypes() : List.of());
            return role;
        }).collect(Collectors.toList());
    }

    public List<Personalization> mapToPersonalizationEntities(List<PersonalizationDTO> personalizationDTOs) {
        return personalizationDTOs.stream().map(dto -> {
            Personalization personalization = new Personalization();
            personalization.setFarmerPrefix(dto.getFarmerPrefix());
            personalization.setFarmerStartNo(dto.getFarmerStartNo());
            personalization.setEmployeePrefix(dto.getEmployeePrefix());
            personalization.setEmployeeStartNo(dto.getEmployeeStartNo());
            personalization.setMailTemplateModule(dto.getMailTemplateModule());
            personalization.setSmsTemplateModule(dto.getSmsTemplateModule());
            return personalization;
        }).collect(Collectors.toList());
    }

    public List<NotificationPreference> mapToNotificationPreferenceEntities(List<NotificationPreferenceDTO> notificationPreferenceDTOs) {
        return notificationPreferenceDTOs.stream().map(dto -> {
            NotificationPreference notificationPreference = new NotificationPreference();
            notificationPreference.setNotificationType(dto.getNotificationType());
            notificationPreference.setStatus(dto.getStatus());
            return notificationPreference;
        }).collect(Collectors.toList());
    }

    public List<LocationSetting> mapToLocationSettingEntities(List<LocationSettingDTO> locationSettingDTOs) {
        return locationSettingDTOs.stream().map(dto -> {
            LocationSetting locationSetting = new LocationSetting();
            locationSetting.setId(dto.getId());
            locationSetting.setCountry(dto.getCountry());
            locationSetting.setState(dto.getState());
            locationSetting.setDistrict(dto.getDistrict());
            locationSetting.setBlock(dto.getBlock());
            locationSetting.setVillage(dto.getVillage());
            locationSetting.setZipcode(dto.getZipcode());
            return locationSetting;
        }).collect(Collectors.toList());
    }

    public List<GlobalSetting> mapToGlobalSettingEntities(List<GlobalSettingDTO> globalSettingDTOs) {
        return globalSettingDTOs.stream().map(dto -> {
            GlobalSetting globalSetting = new GlobalSetting();
            globalSetting.setType(dto.getType());
            globalSetting.setKey(dto.getKey());
            globalSetting.setValue(dto.getValue());
            return globalSetting;
        }).collect(Collectors.toList());
    }

    public List<CropSetting> mapToCropSettingEntities(List<CropSettingDTO> cropSettingDTOs) {
        return cropSettingDTOs.stream().map(dto -> {
            CropSetting cropSetting = new CropSetting();
            cropSetting.setCropFeature(dto.getCropFeature());
            cropSetting.setCropVariety(dto.getCropVariety());
            return cropSetting;
        }).collect(Collectors.toList());
    }

    // Entity to DTO mapping methods

    public UserDTO toUserDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setRoleId(user.getRole() != null ? user.getRole().getId() : null);
        dto.setIsNewUser(user.getIsNewUser());
        return dto;
    }

    public RoleDTO toRoleDTO(Role role) {
        RoleDTO dto = new RoleDTO();
        dto.setRoleName(role.getRoleName());
        dto.setDescription(role.getDescription());
        // Ensure moduleTypes and accessTypes are never null
        dto.setModuleTypes(role.getModuleTypes() != null ? role.getModuleTypes() : List.of());
        dto.setAccessTypes(role.getAccessTypes() != null ? role.getAccessTypes() : List.of());
        return dto;
    }

    public PersonalizationDTO toPersonalizationDTO(Personalization p) {
        PersonalizationDTO dto = new PersonalizationDTO();
        dto.setFarmerPrefix(p.getFarmerPrefix());
        dto.setFarmerStartNo(p.getFarmerStartNo());
        dto.setEmployeePrefix(p.getEmployeePrefix());
        dto.setEmployeeStartNo(p.getEmployeeStartNo());
        dto.setMailTemplateModule(p.getMailTemplateModule());
        dto.setSmsTemplateModule(p.getSmsTemplateModule());
        return dto;
    }

    public NotificationPreferenceDTO toNotificationPreferenceDTO(NotificationPreference n) {
        NotificationPreferenceDTO dto = new NotificationPreferenceDTO();
        dto.setNotificationType(n.getNotificationType());
        dto.setStatus(n.getStatus());
        return dto;
    }

    public LocationSettingDTO toLocationSettingDTO(LocationSetting l) {
        LocationSettingDTO dto = new LocationSettingDTO();
        dto.setId(l.getId());
        dto.setCountry(l.getCountry());
        dto.setState(l.getState());
        dto.setDistrict(l.getDistrict());
        dto.setBlock(l.getBlock());
        dto.setVillage(l.getVillage());
        dto.setZipcode(l.getZipcode());
        return dto;
    }

    public GlobalSettingDTO toGlobalSettingDTO(GlobalSetting g) {
        GlobalSettingDTO dto = new GlobalSettingDTO();
        dto.setType(g.getType());
        dto.setKey(g.getKey());
        dto.setValue(g.getValue());
        return dto;
    }

    public CropSettingDTO toCropSettingDTO(CropSetting c) {
        CropSettingDTO dto = new CropSettingDTO();
        dto.setCropFeature(c.getCropFeature());
        dto.setCropVariety(c.getCropVariety());
        return dto;
    }

    // Response DTO mapping

    public AdminConfigResponseDTO mapToResponse(
        List<User> users,
        List<Role> roles,
        List<Personalization> personalization,
        List<NotificationPreference> notificationPreferences,
        List<LocationSetting> locationSettings,
        List<GlobalSetting> globalSettings,
        List<CropSetting> cropSettings
    ) {
        AdminConfigResponseDTO response = new AdminConfigResponseDTO();
        response.setUsers(users.stream().map(this::toUserDTO).collect(Collectors.toList()));
        response.setRoles(roles.stream().map(this::toRoleDTO).collect(Collectors.toList()));
        response.setPersonalization(personalization.stream().map(this::toPersonalizationDTO).collect(Collectors.toList()));
        response.setNotificationPreferences(notificationPreferences.stream().map(this::toNotificationPreferenceDTO).collect(Collectors.toList()));
        response.setLocationSettings(locationSettings.stream().map(this::toLocationSettingDTO).collect(Collectors.toList()));
        response.setGlobalSettings(globalSettings.stream().map(this::toGlobalSettingDTO).collect(Collectors.toList()));
        response.setCropSettings(cropSettings.stream().map(this::toCropSettingDTO).collect(Collectors.toList()));
        return response;
    }
}
