package com.mohit.portfolio_backend.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ContactRequest {

    @NotBlank
    private String name;
    @Email
    private String email;
    private String company;
    @NotBlank
    @Size(max = 3000, message = "Message cannot exceed 3000 characters")
    private String message;
}