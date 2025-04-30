package com.admin.configuration.repository;

import com.admin.configuration.entity.LocationSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LocationSettingRepository extends JpaRepository<LocationSetting, Long> {
}
