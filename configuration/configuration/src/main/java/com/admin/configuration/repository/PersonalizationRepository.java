package com.admin.configuration.repository;

import com.admin.configuration.entity.Personalization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PersonalizationRepository extends JpaRepository<Personalization, Long> {
}
