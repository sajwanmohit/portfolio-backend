package com.mohit.portfolio_backend.service.impl;

import com.mohit.portfolio_backend.dto.ProjectRequest;
import com.mohit.portfolio_backend.dto.ProjectResponse;
import com.mohit.portfolio_backend.entity.Project;
import com.mohit.portfolio_backend.exception.ResourceNotFoundException;
import com.mohit.portfolio_backend.repository.ProjectRepository;
import com.mohit.portfolio_backend.service.ProjectService;
import com.mohit.portfolio_backend.util.ProjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public ProjectResponse createProject(ProjectRequest request) {

        Project project = ProjectMapper.toEntity(request);

        Project saved = projectRepository.save(project);

        return ProjectMapper.toResponse(saved);
    }

    @Override
    public Page<ProjectResponse> getAllProjects(Pageable pageable) {

        Page<Project> page = projectRepository.findAll(pageable);
        return page.map(ProjectMapper::toResponse);
    }

    @Override
    public ProjectResponse getProject(Long id) {
        return projectRepository.findById(id).map(ProjectMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found"));
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request) {

        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found"));

        ProjectMapper.updateEntity(project,request);

        Project updatedProject = projectRepository.save(project);

        return ProjectMapper.toResponse(updatedProject);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}