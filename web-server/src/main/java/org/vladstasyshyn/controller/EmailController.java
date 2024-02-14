package org.vladstasyshyn.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vladstasyshyn.model.dto.response.EmailConfirmationResponseDTO;
import org.vladstasyshyn.service.EmailConfirmationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/email")
public class EmailController {

    private final EmailConfirmationService confirmationService;

    @GetMapping("/contact/confirm/{code}")
    public EmailConfirmationResponseDTO confirmEmail(@PathVariable String code) {
        return new EmailConfirmationResponseDTO(confirmationService.confirmEmail(code));
    }
}

