package com.mohit.portfolio_backend.repository;

import com.mohit.portfolio_backend.entity.Skill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {

    Page<Skill> findByNameContainingIgnoreCase(String search, Pageable pageable);
    boolean existsByCategoryId(Long categoryId);

}