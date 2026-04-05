package com.mohit.portfolio_backend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProjectRequest {

    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    private String githubUrl;

    private String liveUrl;

    private String imageUrl;

    private String techStack;

    private Boolean isSelected;
}