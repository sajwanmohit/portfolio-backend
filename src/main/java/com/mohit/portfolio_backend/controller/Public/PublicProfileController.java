package com.mohit.portfolio_backend.controller.Public;

import com.mohit.portfolio_backend.dto.ProfileResponse;
import com.mohit.portfolio_backend.entity.Profile;
import com.mohit.portfolio_backend.mapper.ProfileMapper;
import com.mohit.portfolio_backend.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public/profile")
@RequiredArgsConstructor
public class PublicProfileController {

    private final ProfileService profileService;

    @GetMapping
    public ProfileResponse getProfile() {
        Profile profile = profileService.getProfile();
        return profile != null ? ProfileMapper.toResponse(profile) : null;
    }
}