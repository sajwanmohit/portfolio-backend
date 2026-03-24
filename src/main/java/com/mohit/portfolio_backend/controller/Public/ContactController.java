package com.mohit.portfolio_backend.controller.Public;

import com.mohit.portfolio_backend.dto.ContactRequest;
import com.mohit.portfolio_backend.dto.ContactResponse;
import com.mohit.portfolio_backend.entity.Contact;
import com.mohit.portfolio_backend.service.ContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @PostMapping
    public Contact sendMessage(
            @Valid @RequestBody ContactRequest request) {

        return contactService.save(request);

    }


}