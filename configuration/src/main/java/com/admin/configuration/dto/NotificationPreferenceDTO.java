package com.admin.configuration.dto;

import com.admin.configuration.Enum.ToggleStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NotificationPreferenceDTO {

    @NotNull(message = "Notification type cannot be null")
    @NotBlank(message = "Notification type cannot be blank")
    private String notificationType;

    @NotNull(message = "Status cannot be null")
    private ToggleStatus status;
}

