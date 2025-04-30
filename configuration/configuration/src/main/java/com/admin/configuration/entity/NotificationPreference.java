package com.admin.configuration.entity;

import com.admin.configuration.Enum.ToggleStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class NotificationPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Notification type must not be null")
    @Size(min = 1, max = 50, message = "Notification type must be between 1 and 50 characters")
    private String notificationType; // e.g., Email, SMS

    @NotNull(message = "Status must not be null")
    @Enumerated(EnumType.STRING)
    private ToggleStatus status; // ON or OFF
}
