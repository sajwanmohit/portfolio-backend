package com.mohit.portfolio_backend.repository;

import com.mohit.portfolio_backend.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    Page<Project> findByTitleContainingIgnoreCase(String title, Pageable pageable);
    Page<Project> findByIsSelectedTrue(Pageable pageable);
}