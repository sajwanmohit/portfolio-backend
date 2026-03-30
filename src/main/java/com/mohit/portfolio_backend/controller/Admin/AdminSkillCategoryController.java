package com.mohit.portfolio_backend.controller.Admin;

import com.mohit.portfolio_backend.entity.SkillCategory;
import com.mohit.portfolio_backend.repository.SkillCategoryRepository;
import com.mohit.portfolio_backend.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/skill-categories")
@RequiredArgsConstructor
public class AdminSkillCategoryController {

    private final SkillCategoryRepository repository;
    private final SkillRepository skillRepository;

    @PostMapping
    public SkillCategory create(@RequestBody SkillCategory category) {
        return repository.save(category);
    }

    @GetMapping
    public List<SkillCategory> getAll() {
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        // Check if category exists
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        // Check if any skill is using this category
        if (skillRepository.existsByCategoryId(id)) {
            return ResponseEntity
                    .badRequest()
                    .body("Cannot delete category. Skills are still assigned.");
        }

        // Safe delete
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}