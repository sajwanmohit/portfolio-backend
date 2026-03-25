package com.mohit.portfolio_backend.controller.Admin;

import com.mohit.portfolio_backend.entity.Contact;
import com.mohit.portfolio_backend.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/contacts")
@RequiredArgsConstructor
public class AdminContactController {

    private final ContactService contactService;

    @GetMapping
    public Page<Contact> getContacts(
            @ParameterObject Pageable pageable,
            @RequestParam(required = false) String search
    ) {
        return contactService.getContacts(pageable, search);
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id) {
        contactService.delete(id);
    }
}