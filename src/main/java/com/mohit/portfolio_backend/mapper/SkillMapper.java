package com.mohit.portfolio_backend.mapper;

import com.mohit.portfolio_backend.dto.SkillRequest;
import com.mohit.portfolio_backend.dto.SkillResponse;
import com.mohit.portfolio_backend.entity.Skill;
import com.mohit.portfolio_backend.entity.SkillCategory;

public class SkillMapper {

    public static Skill toEntity(SkillRequest request, SkillCategory category) {
        Skill skill = new Skill();
        skill.setName(request.getName());
        skill.setLevel(request.getLevel());
        skill.setCategory(category);
        return skill;
    }

    public static void updateEntity(Skill skill, SkillRequest request, SkillCategory category) {
        skill.setName(request.getName());
        skill.setLevel(request.getLevel());
        skill.setCategory(category);
    }

    public static SkillResponse toResponse(Skill skill) {
        return new SkillResponse(
                skill.getId(),
                skill.getName(),
                skill.getLevel(),
                skill.getCategory().getId(),
                skill.getCategory().getName()
        );
    }
}