package com.mohit.portfolio_backend.service;

import com.mohit.portfolio_backend.dto.SkillRequest;
import com.mohit.portfolio_backend.dto.SkillResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SkillService {

    SkillResponse create(SkillRequest request);

    SkillResponse update(Long id, SkillRequest request);

    void delete(Long id);

    public List<SkillResponse> getAll();  // for public

    Page<SkillResponse> getAll(int page, int size);
}