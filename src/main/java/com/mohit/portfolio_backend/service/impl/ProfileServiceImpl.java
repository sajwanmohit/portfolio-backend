package com.mohit.portfolio_backend.service.impl;

import com.mohit.portfolio_backend.entity.Profile;
import com.mohit.portfolio_backend.repository.ProfileRepository;
import com.mohit.portfolio_backend.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    @Override
    public Profile getProfile() {
        return profileRepository.findAll()
                .stream()
                .findFirst()
                .orElse(null);
    }
}