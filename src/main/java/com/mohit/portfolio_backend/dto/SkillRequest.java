package com.mohit.portfolio_backend.dto;

import com.mohit.portfolio_backend.enums.SkillLevel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkillRequest {

    @NotBlank
    private String name;

    private SkillLevel level;

    @NotNull
    private Long categoryId; // ✅ REQUIRED for relation
}