package com.mohit.portfolio_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkillRequest {

    @NotBlank
    private String name;

    private String level;

    @NotNull
    private Long categoryId; // ✅ REQUIRED for relation
}