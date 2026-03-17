package com.mohit.portfolio_backend.service.impl;

import com.mohit.portfolio_backend.dto.SkillRequest;
import com.mohit.portfolio_backend.dto.SkillResponse;
import com.mohit.portfolio_backend.entity.Skill;
import com.mohit.portfolio_backend.mapper.SkillMapper;
import com.mohit.portfolio_backend.repository.SkillRepository;
import com.mohit.portfolio_backend.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

    private final SkillRepository repository;
    private final SkillMapper mapper;

    @Override
    public SkillResponse create(SkillRequest request) {
        Skill skill = mapper.toEntity(request);
        return mapper.toResponse(repository.save(skill));
    }

    @Override
    public List<SkillResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}