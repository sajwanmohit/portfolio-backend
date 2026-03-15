package com.mohit.portfolio_backend.controller;

import com.mohit.portfolio_backend.dto.ProjectRequest;
import com.mohit.portfolio_backend.dto.ProjectResponse;
import com.mohit.portfolio_backend.entity.Project;
import com.mohit.portfolio_backend.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ProjectResponse createProject(@Valid @RequestBody ProjectRequest request) {
        return projectService.createProject(request);
    }

    @GetMapping
    public List<ProjectResponse> getProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public ProjectResponse getProject(@PathVariable Long id) {
        return projectService.getProject(id);
    }

    @PutMapping("/{id}")
    public ProjectResponse updateProject(
            @PathVariable Long id,
            @RequestBody ProjectRequest project
    ) {
        return projectService.updateProject(id, project);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }
}