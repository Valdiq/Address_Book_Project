package org.vladstasyshyn.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vladstasyshyn.model.entity.ContactDetailsEntity;
import org.vladstasyshyn.repository.ContactDetailsRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactDetailsService {

    private final ContactDetailsRepository repository;

    public Optional<ContactDetailsEntity> findByContactEntityId(Long id) {
        return Optional.ofNullable(repository.findByContactEntityId(id)
                .orElseThrow(() -> new RuntimeException("Contact Details Not Found")));
    }
}
