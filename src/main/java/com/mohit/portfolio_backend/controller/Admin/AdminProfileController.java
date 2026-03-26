package com.mohit.portfolio_backend.controller.Admin;

import com.mohit.portfolio_backend.dto.ProfileRequest;
import com.mohit.portfolio_backend.dto.ProfileResponse;
import com.mohit.portfolio_backend.entity.Profile;
import com.mohit.portfolio_backend.mapper.ProfileMapper;
import com.mohit.portfolio_backend.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/profile")
@RequiredArgsConstructor
public class AdminProfileController {

    private final ProfileService profileService;

    @PostMapping
    public ProfileResponse saveProfile(@RequestBody ProfileRequest request) {
        Profile saved = profileService.saveOrUpdate(request);
        return ProfileMapper.toResponse(saved);
    }
}