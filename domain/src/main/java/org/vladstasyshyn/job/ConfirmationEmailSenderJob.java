package org.vladstasyshyn.job;


import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.vladstasyshyn.service.EmailService;
import org.vladstasyshyn.model.entity.EmailConfirmationEntity;
import org.vladstasyshyn.service.EmailConfirmationService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ConfirmationEmailSenderJob {

    private final EmailConfirmationService confirmationService;

    private final EmailService emailService;

    @Async
    @Scheduled(fixedDelay = (1000 * 60))
    public void sendConfirmationEmail() {
        System.out.println("ASYNC JOB!");
        List<EmailConfirmationEntity> emailsList = confirmationService.findAllBySent(false);

        for (EmailConfirmationEntity confirmationEntity : emailsList) {
            String email = confirmationEntity.getContactDetails().getEmail();
            emailService.sendConfirmationEmail(email, confirmationEntity.getCode());
            confirmationService.markAsSent(confirmationEntity.getCode());
        }
    }

}
