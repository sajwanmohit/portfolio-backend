package com.mohit.portfolio_backend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkillRequest {
    @NotBlank
    private String name;

    private String level;
}