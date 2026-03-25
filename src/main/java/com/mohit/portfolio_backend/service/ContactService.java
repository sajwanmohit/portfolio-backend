package com.mohit.portfolio_backend.service;

import com.mohit.portfolio_backend.dto.ContactRequest;
import com.mohit.portfolio_backend.entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContactService {

    Contact save(ContactRequest request);

    Page<Contact> getContacts(Pageable pageable, String search);

    void delete(Long id);

}