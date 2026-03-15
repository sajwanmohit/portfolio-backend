package com.mohit.portfolio_backend.util;

import com.mohit.portfolio_backend.dto.ProjectRequest;
import com.mohit.portfolio_backend.dto.ProjectResponse;
import com.mohit.portfolio_backend.entity.Project;

public class ProjectMapper {

    public static Project toEntity(ProjectRequest request) {
        return Project.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .githubUrl(request.getGithubUrl())
                .liveUrl(request.getLiveUrl())
                .imageUrl(request.getImageUrl())
                .techStack(request.getTechStack())
                .build();
    }

    public static ProjectResponse toResponse(Project project) {
        return ProjectResponse.builder()
                .id(project.getId())
                .title(project.getTitle())
                .description(project.getDescription())
                .githubUrl(project.getGithubUrl())
                .liveUrl(project.getLiveUrl())
                .imageUrl(project.getImageUrl())
                .techStack(project.getTechStack())
                .build();
    }
    public static void updateEntity(Project project, ProjectRequest request) {
        project.setTitle(request.getTitle());
        project.setDescription(request.getDescription());
        project.setGithubUrl(request.getGithubUrl());
        project.setLiveUrl(request.getLiveUrl());
        project.setImageUrl(request.getImageUrl());
        project.setTechStack(request.getTechStack());
    }
}