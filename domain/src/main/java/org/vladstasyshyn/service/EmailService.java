package org.vladstasyshyn.service;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.vladstasyshyn.model.entity.ContactDetailsEntity;
import org.vladstasyshyn.model.entity.EmailConfirmationEntity;
import org.vladstasyshyn.repository.EmailConfirmationRepository;
import org.vladstasyshyn.util.RandomString;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    private final RandomString randomString;

    private final EmailConfirmationRepository repository;

    private static final String CONFIRMATION_LINK = "http://localhost:8080/api/confirmation/";

    public void sendGreetingEmail(String to, String fullName) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(to);
        mailMessage.setSubject("Greeting");
        mailMessage.setText("Welcome To Address Book, " + fullName);

        mailSender.send(mailMessage);
    }

    public void sendConfirmationEmail(String to, String code) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        String confirmationLink = CONFIRMATION_LINK + code;

        mailMessage.setTo(to);
        mailMessage.setSubject("Confirm Your Email");
        mailMessage.setText("Confirmation Link: " + confirmationLink);

        mailSender.send(mailMessage);
    }

    public EmailConfirmationEntity createConfirmationEntity(ContactDetailsEntity contactDetailsEntity) {
        String confirmationCode = randomString.genarate();
        var confirmationEntity = new EmailConfirmationEntity()
                .setSent(false)
                .setConfirmed(false)
                .setCode(confirmationCode)
                .setContactDetails(contactDetailsEntity);
        return repository.save(confirmationEntity);
    }

}
