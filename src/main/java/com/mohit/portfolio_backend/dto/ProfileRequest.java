package com.mohit.portfolio_backend.dto;

import lombok.Data;

@Data
public class ProfileRequest {
    private String name;
    private String designation;
    private String about;
    private String ownerGithubProfileURL;
    private String ownerLinkedinProfileURL;
    private String ownerEmailAddress;
}