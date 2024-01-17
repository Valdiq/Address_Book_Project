package org.vlad_stasyshyn.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vlad_stasyshyn.mapper.ContactEntityMapper;
import org.vlad_stasyshyn.model.dao.ContactDAO;
import org.vlad_stasyshyn.model.entity.ContactEntity;
import org.vlad_stasyshyn.repository.ContactRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository repository;

    private final ContactEntityMapper contactEntityMapper;


    public ContactEntity getContact(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact Not Found"));
    }

    public Optional<List<ContactEntity>> getAllContacts() {
        return Optional.ofNullable(Optional.of(repository.findAll())
                .orElseThrow(() -> new RuntimeException("No Contacts Found")));
    }


    public ContactEntity createContact(ContactDAO contactDAO) {
        return repository.save(contactEntityMapper.mapContactDAOToContactEntity(contactDAO));
    }

    public ContactEntity updateContact(ContactDAO contactDAO) {
        return repository.save(contactEntityMapper.mapContactDAOToContactEntity(contactDAO));
    }

    public void deleteContact(Long id) {
        repository.deleteById(id);
    }
}
