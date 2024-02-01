package org.vladstasyshyn.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vladstasyshyn.security.authentication.AuthenticationRequestDTO;
import org.vladstasyshyn.security.authentication.AuthenticationResponseDTO;
import org.vladstasyshyn.security.authentication.AuthenticationService;
import org.vladstasyshyn.security.authentication.RegisterRequestDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class UserController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public AuthenticationResponseDTO register(@RequestBody RegisterRequestDTO requestDTO) {
        return service.register(requestDTO);
    }

    @PostMapping("/authenticate")
    public AuthenticationResponseDTO authenticate(@RequestBody AuthenticationRequestDTO authenticationRequestDTO) {
        return service.authenticate(authenticationRequestDTO);
    }
}
