package com.mohit.portfolio_backend.repository;

import com.mohit.portfolio_backend.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}