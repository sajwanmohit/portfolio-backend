package com.mohit.portfolio_backend.service.impl;

import com.mohit.portfolio_backend.dto.ContactRequest;
import com.mohit.portfolio_backend.entity.ContactMessage;
import com.mohit.portfolio_backend.mapper.ContactMapper;
import com.mohit.portfolio_backend.repository.ContactRepository;
import com.mohit.portfolio_backend.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository repository;
    private final ContactMapper mapper;

    @Override
    public void saveMessage(ContactRequest request) {
        ContactMessage entity = mapper.toEntity(request);
        repository.save(entity);
    }
}