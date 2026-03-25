package com.mohit.portfolio_backend.controller.Public;

import com.mohit.portfolio_backend.entity.Profile;
import com.mohit.portfolio_backend.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public/site-settings")
@RequiredArgsConstructor
public class SiteSettingsController {

    private final ProfileService profileService;

    @GetMapping
    public Profile getSettings() {
        return profileService.getProfile();
    }
}