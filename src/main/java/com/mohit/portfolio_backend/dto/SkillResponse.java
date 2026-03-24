package com.mohit.portfolio_backend.dto;

import com.mohit.portfolio_backend.enums.SkillLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SkillResponse {

    private Long id;
    private String name;
    private SkillLevel level;

    private Long categoryId;     // ✅ needed for edit/update
    private String categoryName; // ✅ needed for UI grouping
}