package com.mohit.portfolio_backend.controller.Admin;

import com.mohit.portfolio_backend.dto.SkillRequest;
import com.mohit.portfolio_backend.dto.SkillResponse;
import com.mohit.portfolio_backend.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/skills")
@RequiredArgsConstructor
public class AdminSkillController {

    private final SkillService skillService;

    @PostMapping
    public SkillResponse create(@RequestBody SkillRequest request) {
        return skillService.create(request);
    }

    @PutMapping("/{id}")
    public SkillResponse update(
            @PathVariable Long id,
            @RequestBody SkillRequest request
    ) {
        return skillService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        skillService.delete(id);
    }

    @GetMapping
    public Page<SkillResponse> getAll(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(required = false) String search
    ) {
        return skillService.getAll(page, size, search);
    }
}