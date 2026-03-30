package com.mohit.portfolio_backend.service.impl;

import com.mohit.portfolio_backend.dto.SkillRequest;
import com.mohit.portfolio_backend.dto.SkillResponse;
import com.mohit.portfolio_backend.entity.Skill;
import com.mohit.portfolio_backend.entity.SkillCategory;
import com.mohit.portfolio_backend.mapper.SkillMapper;
import com.mohit.portfolio_backend.repository.SkillCategoryRepository;
import com.mohit.portfolio_backend.repository.SkillRepository;
import com.mohit.portfolio_backend.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;
    private final SkillCategoryRepository categoryRepository;

    @Override
    public SkillResponse create(SkillRequest request) {
        SkillCategory category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Skill skill = SkillMapper.toEntity(request,category);

        return SkillMapper.toResponse(skillRepository.save(skill));
    }

    @Override
    public SkillResponse update(Long id, SkillRequest request) {
        Skill skill = skillRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found"));

        SkillCategory category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        SkillMapper.updateEntity(skill,request,category);

        return SkillMapper.toResponse(skillRepository.save(skill));
    }

    @Override
    public void delete(Long id) {
        skillRepository.deleteById(id);
    }

    @Override
    public Page<SkillResponse> getAll(int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());

        return skillRepository.findAll(pageable)
                .map(SkillMapper::toResponse);
    }
}