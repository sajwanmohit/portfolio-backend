package com.mohit.portfolio_backend.service;

import com.mohit.portfolio_backend.dto.ProjectRequest;
import com.mohit.portfolio_backend.dto.ProjectResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    ProjectResponse createProject(ProjectRequest request);

    Page<ProjectResponse> getAllProjects(Pageable pageable);

    ProjectResponse getProject(Long id);

    ProjectResponse updateProject(Long id, ProjectRequest request);

    void deleteProject(Long id);
}