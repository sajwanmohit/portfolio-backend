package com.mohit.portfolio_backend.repository;

import com.mohit.portfolio_backend.entity.SkillCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SkillCategoryRepository extends JpaRepository<SkillCategory, Long> {

    Optional<SkillCategory> findByNameIgnoreCase(String name);
}