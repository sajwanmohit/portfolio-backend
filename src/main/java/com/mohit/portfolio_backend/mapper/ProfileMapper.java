package com.mohit.portfolio_backend.mapper;

import com.mohit.portfolio_backend.dto.ProfileRequest;
import com.mohit.portfolio_backend.dto.ProfileResponse;
import com.mohit.portfolio_backend.entity.Profile;

public class ProfileMapper {

    public static Profile toEntity(ProfileRequest req) {
        return Profile.builder()
                .name(req.getName())
                .designation(req.getDesignation())
                .about(req.getAbout())
                .ownerGithubProfileURL(req.getOwnerGithubProfileURL())
                .ownerLinkedinProfileURL(req.getOwnerLinkedinProfileURL())
                .ownerEmailAddress(req.getOwnerEmailAddress())
                .build();
    }

    public static ProfileResponse toResponse(Profile profile) {
        return ProfileResponse.builder()
                .name(profile.getName())
                .designation(profile.getDesignation())
                .about(profile.getAbout())
                .ownerGithubProfileURL(profile.getOwnerGithubProfileURL())
                .ownerLinkedinProfileURL(profile.getOwnerLinkedinProfileURL())
                .ownerEmailAddress(profile.getOwnerEmailAddress())
                .build();
    }

    public static void update(Profile existing, ProfileRequest req) {
        existing.setName(req.getName());
        existing.setDesignation(req.getDesignation());
        existing.setAbout(req.getAbout());
        existing.setOwnerGithubProfileURL(req.getOwnerGithubProfileURL());
        existing.setOwnerLinkedinProfileURL(req.getOwnerLinkedinProfileURL());
        existing.setOwnerEmailAddress(req.getOwnerEmailAddress());
    }
}