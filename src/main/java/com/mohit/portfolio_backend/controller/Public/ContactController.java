package com.mohit.portfolio_backend.controller.Public;

import com.mohit.portfolio_backend.dto.ContactRequest;
import com.mohit.portfolio_backend.dto.ContactResponse;
import com.mohit.portfolio_backend.service.ContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public/contact")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService service;

    /*
    sample request:
    {
  "name": "Mohit",
  "email": "test@gmail.com",
  "company": "Fiserv",
  "message": "Hello, let's connect"
}
sample response:
{
  "message": "Message sent successfully"
}
     */
    @PostMapping
    public ResponseEntity<ContactResponse> sendMessage(
            @Valid @RequestBody ContactRequest request) {

        service.saveMessage(request);

        return ResponseEntity.ok(
                new ContactResponse("Message sent successfully")
        );
    }
}