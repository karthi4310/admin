package com.admin.configuration;

import com.admin.configuration.Enum.AccessType;
import com.admin.configuration.Enum.ModuleType;
import com.admin.configuration.dto.*;
import com.admin.configuration.entity.*;
import com.admin.configuration.exception.ConfigurationValidationException;
import com.admin.configuration.mapper.AdminConfigMapper;
import com.admin.configuration.repository.*;
import com.admin.configuration.service.AdminConfigService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AdminConfigServiceTest {

    @Mock private UserRepository userRepository;
    @Mock private RoleRepository roleRepository;
    @Mock private PersonalizationRepository personalizationRepository;
    @Mock private NotificationPreferenceRepository notificationPreferenceRepository;
    @Mock private LocationSettingRepository locationSettingRepository;
    @Mock private GlobalSettingRepository globalSettingRepository;
    @Mock private CropSettingRepository cropSettingRepository;
    @Mock private AdminConfigMapper mapper;

    @InjectMocks
    private AdminConfigService adminConfigService;

    private AdminConfigRequestDTO requestDTO;

    @BeforeEach
    void setup() {
        requestDTO = new AdminConfigRequestDTO();

        // Mock UserDTO
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("testuser");
        userDTO.setEmail("testuser@example.com");
        userDTO.setRoleId(1L); // Assuming 1L corresponds to a valid role
        userDTO.setIsNewUser(true);

        // Mock RoleDTO
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleName("Admin");
        roleDTO.setModuleTypes(Collections.singletonList(ModuleType.EMPLOYEE)); // Assuming this is a valid module type
        roleDTO.setAccessTypes(Arrays.asList(AccessType.ADD, AccessType.VIEW, AccessType.EDIT, AccessType.DELETE));
 // Assuming this is a valid access type

        // Mock PersonalizationDTO with required fields
        PersonalizationDTO personalizationDTO = new PersonalizationDTO();
        personalizationDTO.setFarmerPrefix("FARM");
        personalizationDTO.setFarmerStartNo("001");
        personalizationDTO.setEmployeePrefix("EMP");
        personalizationDTO.setEmployeeStartNo("100");
        personalizationDTO.setMailTemplateModule("REGISTRATION");
        personalizationDTO.setSmsTemplateModule("REGISTRATION_SMS");

        requestDTO.setUsers(List.of(userDTO));
        requestDTO.setRoles(List.of(roleDTO));
        requestDTO.setPersonalization(List.of(personalizationDTO));
    }

    @Test
    void testGetAllConfigurationData_returnsAggregatedData() {
        AdminConfigResponseDTO mockResponse = new AdminConfigResponseDTO();
        when(userRepository.findAll()).thenReturn(Collections.emptyList());
        when(roleRepository.findAll()).thenReturn(Collections.emptyList());
        when(personalizationRepository.findAll()).thenReturn(Collections.emptyList());
        when(notificationPreferenceRepository.findAll()).thenReturn(Collections.emptyList());
        when(locationSettingRepository.findAll()).thenReturn(Collections.emptyList());
        when(globalSettingRepository.findAll()).thenReturn(Collections.emptyList());
        when(cropSettingRepository.findAll()).thenReturn(Collections.emptyList());
        when(mapper.mapToResponse(any(), any(), any(), any(), any(), any(), any()))
                .thenReturn(mockResponse);

        AdminConfigResponseDTO result = adminConfigService.getAllConfigurationData();

        assertNotNull(result);
        verify(mapper).mapToResponse(any(), any(), any(), any(), any(), any(), any());
    }

    @Test
    void testSaveConfigurationData_savesValidData() {
        // Mock the mapping to entities
        when(mapper.mapToUserEntities(anyList())).thenReturn(List.of(new User()));
        when(mapper.mapToRoleEntities(anyList())).thenReturn(List.of(new Role()));
        when(mapper.mapToPersonalizationEntities(anyList())).thenReturn(List.of(new Personalization()));
        // Add mocks for other entities if needed

        // Call the saveConfigurationData method
        adminConfigService.saveConfigurationData(requestDTO);

        // Verify that repositories are saving the entities
        verify(userRepository).saveAll(any());
        verify(roleRepository).saveAll(any());
        verify(personalizationRepository).saveAll(any());
        // Add verifications for other repositories if needed
    }

    @Test
    void testSaveConfigurationData_throwsValidationException_whenUsersMissing() {
        requestDTO.setUsers(null);
        ConfigurationValidationException ex = assertThrows(ConfigurationValidationException.class, () -> {
            adminConfigService.saveConfigurationData(requestDTO);
        });
        assertEquals("Users configuration is required.", ex.getMessage());
    }

    @Test
    void testSaveConfigurationData_throwsValidationException_whenRolesMissing() {
        requestDTO.setRoles(null);
        ConfigurationValidationException ex = assertThrows(ConfigurationValidationException.class, () -> {
            adminConfigService.saveConfigurationData(requestDTO);
        });
        assertEquals("Roles configuration is required.", ex.getMessage());
    }

    @Test
    void testSaveConfigurationData_throwsValidationException_whenPersonalizationMissing() {
        requestDTO.setPersonalization(null);
        ConfigurationValidationException ex = assertThrows(ConfigurationValidationException.class, () -> {
            adminConfigService.saveConfigurationData(requestDTO);
        });
        assertEquals("Personalization configuration is required.", ex.getMessage());
    }
}
