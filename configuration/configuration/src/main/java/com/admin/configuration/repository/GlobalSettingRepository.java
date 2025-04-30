package com.admin.configuration.repository;

import com.admin.configuration.entity.GlobalSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GlobalSettingRepository extends JpaRepository<GlobalSetting, Long> {
    List<GlobalSetting> findByType(String type);
}

