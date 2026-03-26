package com.mohit.portfolio_backend.service;

import com.mohit.portfolio_backend.dto.ProfileRequest;
import com.mohit.portfolio_backend.entity.Profile;

public interface ProfileService {
    Profile getProfile();
    Profile saveOrUpdate(ProfileRequest request);
}