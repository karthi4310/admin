package com.admin.configuration.repository;

import com.admin.configuration.entity.CropSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CropSettingRepository extends JpaRepository<CropSetting, Long> {
    List<CropSetting> findByCropFeature(String cropFeature);
}
