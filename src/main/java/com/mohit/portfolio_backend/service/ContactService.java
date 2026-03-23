package com.mohit.portfolio_backend.service;

import com.mohit.portfolio_backend.dto.ContactRequest;

public interface ContactService {
    void saveMessage(ContactRequest request);
}