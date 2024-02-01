package org.vladstasyshyn.security.authentication;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.vladstasyshyn.security.jwt.JWTService;
import org.vladstasyshyn.security.user.UserEntity;
import org.vladstasyshyn.security.user.UserRepository;

@Service
@RequiredArgsConstructor
@Validated
public class AuthenticationService {

    private final UserRepository repository;

    private final PasswordEncoder encoder;

    private final JWTService jwtService;

    private final AuthenticationManager manager;

    public AuthenticationResponseDTO register(@Valid RegisterRequestDTO requestDTO) {
        var user = new UserEntity()
                .setUsername(requestDTO.getUsername())
                .setPassword(encoder.encode(requestDTO.getPassword()))
                .setRoles(requestDTO.getRoles());

        var jwtToken = jwtService.generateToken(user);
        repository.save(user);

        return new AuthenticationResponseDTO().setToken(jwtToken);
    }

    public AuthenticationResponseDTO authenticate(@Valid AuthenticationRequestDTO requestDTO) {
        manager.authenticate(new UsernamePasswordAuthenticationToken(requestDTO.getUsername(), requestDTO.getPassword()));

        var user = repository.findByUsername(requestDTO.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User with username " + requestDTO.getUsername() + " not found"));

        var jwtToken = jwtService.generateToken(user);

        return new AuthenticationResponseDTO().setToken(jwtToken);
    }

}
