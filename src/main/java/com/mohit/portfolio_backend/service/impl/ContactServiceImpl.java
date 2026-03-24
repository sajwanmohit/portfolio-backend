package com.mohit.portfolio_backend.service.impl;

import com.mohit.portfolio_backend.dto.ContactRequest;
import com.mohit.portfolio_backend.entity.Contact;
import com.mohit.portfolio_backend.repository.ContactRepository;
import com.mohit.portfolio_backend.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    public Contact save(ContactRequest request) {
        Contact contact = Contact.builder()
                .name(request.getName())
                .email(request.getEmail())
                .company(request.getCompany())
                .message(request.getMessage())
                .createdAt(LocalDateTime.now())
                .build();

        return contactRepository.save(contact);
    }

    @Override
    public Page<Contact> getContacts(Pageable pageable, String search) {

        if (StringUtils.hasText(search)) {
            return contactRepository
                    .findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
                            search,
                            search,
                            pageable
                    );
        }

        return contactRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
        contactRepository.deleteById(id);
    }
}