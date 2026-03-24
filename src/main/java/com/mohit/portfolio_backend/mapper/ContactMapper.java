package com.mohit.portfolio_backend.mapper;

import com.mohit.portfolio_backend.dto.ContactRequest;
import com.mohit.portfolio_backend.entity.Contact;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {

    public Contact toEntity(ContactRequest request) {
        Contact entity = new Contact();
        entity.setName(request.getName());
        entity.setEmail(request.getEmail());
        entity.setCompany(request.getCompany());
        entity.setMessage(request.getMessage());
        return entity;
    }
}