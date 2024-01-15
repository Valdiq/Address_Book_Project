package org.vlad_stasyshyn.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vlad_stasyshyn.entity.ContactEntity;
import org.vlad_stasyshyn.repository.ContactRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository repository;


    public ContactEntity getContact(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact Not Found"));
    }

    public Optional<List<ContactEntity>> getAllContacts() {
        return Optional.ofNullable(Optional.of(repository.findAll())
                .orElseThrow(() -> new RuntimeException("No Contacts Found")));
    }


    public ContactEntity createContact(ContactEntity contact) {
        return repository.save(contact);
    }


    public ContactEntity updateContact(ContactEntity contact) {
        return repository.save(contact);
    }

    public void deleteContact(Long id) {
        repository.deleteById(id);
    }
}
