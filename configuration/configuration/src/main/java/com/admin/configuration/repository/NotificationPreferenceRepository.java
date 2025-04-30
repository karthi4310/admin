package com.admin.configuration.repository;

import com.admin.configuration.entity.NotificationPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface NotificationPreferenceRepository extends JpaRepository<NotificationPreference, Long> {
}
