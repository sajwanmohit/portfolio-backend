package com.mohit.portfolio_backend.controller.Public;

import com.mohit.portfolio_backend.dto.SkillResponse;
import com.mohit.portfolio_backend.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/public/skills")
@RequiredArgsConstructor
public class PublicSkillController {

    private final SkillService service;

    @GetMapping
    public List<SkillResponse> getAll() {
        return service.getAll();
    }
}