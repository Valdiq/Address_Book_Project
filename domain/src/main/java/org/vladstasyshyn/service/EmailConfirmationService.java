package org.vladstasyshyn.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vladstasyshyn.exceptionhandling.ConfirmationCodeNotFound;
import org.vladstasyshyn.model.entity.EmailConfirmationEntity;
import org.vladstasyshyn.repository.EmailConfirmationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailConfirmationService {
    private final EmailConfirmationRepository repository;

    public String confirmEmail(String id) {
        var entity = repository.findById(id)
                .orElseThrow(ConfirmationCodeNotFound::new);

        if (!entity.isConfirmed()) {
            entity.setConfirmed(true);
            repository.save(entity);
            return "Successfully Confirmed!";
        }
        return "Already Was Confirmed";
    }

    public void markAsSent(String id) {
        var entity = repository.findById(id)
                .orElseThrow(ConfirmationCodeNotFound::new)
                .setSent(true);
        repository.save(entity);
    }

    public List<EmailConfirmationEntity> findAllBySent(boolean sent) {
        return repository.findAllBySent(sent);
    }
}
