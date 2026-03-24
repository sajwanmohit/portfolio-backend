package com.mohit.portfolio_backend.controller.Admin;

import com.mohit.portfolio_backend.entity.SkillCategory;
import com.mohit.portfolio_backend.repository.SkillCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/skill-categories")
@RequiredArgsConstructor
public class AdminSkillCategoryController {

    private final SkillCategoryRepository repository;

    @PostMapping
    public SkillCategory create(@RequestBody SkillCategory category) {
        return repository.save(category);
    }

    @GetMapping
    public List<SkillCategory> getAll() {
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}