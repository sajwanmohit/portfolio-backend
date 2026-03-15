package com.mohit.portfolio_backend.service;

import com.mohit.portfolio_backend.dto.ProjectRequest;
import com.mohit.portfolio_backend.dto.ProjectResponse;

import java.util.List;

public interface ProjectService {

    ProjectResponse createProject(ProjectRequest request);

    List<ProjectResponse> getAllProjects();

    ProjectResponse getProject(Long id);

    ProjectResponse updateProject(Long id, ProjectRequest request);

    void deleteProject(Long id);
}