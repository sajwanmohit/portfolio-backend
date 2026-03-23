package com.mohit.portfolio_backend.service;

import com.mohit.portfolio_backend.dto.SkillRequest;
import com.mohit.portfolio_backend.dto.SkillResponse;

import java.util.List;

public interface SkillService {
    SkillResponse create(SkillRequest request);
    List<SkillResponse> getAll();
}