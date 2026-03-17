package com.mohit.portfolio_backend.mapper;

import com.mohit.portfolio_backend.dto.ContactRequest;
import com.mohit.portfolio_backend.entity.ContactMessage;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {

    public ContactMessage toEntity(ContactRequest request) {
        ContactMessage entity = new ContactMessage();
        entity.setName(request.getName());
        entity.setEmail(request.getEmail());
        entity.setCompany(request.getCompany());
        entity.setMessage(request.getMessage());
        return entity;
    }
}