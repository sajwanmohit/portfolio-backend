package com.mohit.portfolio_backend.dto;

import lombok.Data;

@Data
public class ContactRequest {
    private String name;
    private String email;
    private String company;
    private String message;
}