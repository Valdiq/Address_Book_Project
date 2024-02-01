package org.vladstasyshyn.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.vladstasyshyn.exceptionhandling.ContactNotFoundException;
import org.vladstasyshyn.mapper.ContactEntityDAOMapper;
import org.vladstasyshyn.model.dao.ContactDAO;
import org.vladstasyshyn.model.entity.CompanyEntity;
import org.vladstasyshyn.model.entity.ContactEntity;
import org.vladstasyshyn.model.entity.PersonEntity;
import org.vladstasyshyn.repository.ContactRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
@Validated
public class ContactService {

    private final ContactRepository repository;

    private final ContactEntityDAOMapper contactEntityDAOMapper;


    @Transactional(readOnly = true)
    public ContactEntity getContact(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException(id));
    }

    @Transactional(readOnly = true)
    public Optional<List<ContactEntity>> getAllContacts() {
        return Optional.ofNullable(Optional.of(repository.findAll())
                .orElseThrow(ContactNotFoundException::new));
    }


    public ContactEntity createContact(@Valid ContactDAO contactDAO) {
        return repository.save(contactEntityDAOMapper.mapContactDAOToContactEntity(contactDAO));
    }

    public ContactEntity updateContact(Long id, @Valid ContactDAO contactDAO) {

        var contactToUpdate = repository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException(id));

        var newContact = contactEntityDAOMapper.mapContactDAOToContactEntity(contactDAO)
                .setId(contactToUpdate.getId()); // <-- setting ID from ContactDAO to ContactEntity automatically by mapper(mapstruct) doesn't work for some reason.
        // Will be fixed in final debug branch in future (when I'll figure it out wtf it's going wrong with it lol) :)

        if (newContact instanceof CompanyEntity newCompanyEntity
                && contactToUpdate instanceof CompanyEntity companyEntityToUpdate) {
            if (newCompanyEntity.getNIP() == null) {
                newCompanyEntity.setNIP(companyEntityToUpdate.getNIP());
            }
        }

        if (newContact instanceof PersonEntity newPersonEntity
                && contactToUpdate instanceof PersonEntity personEntityToUpdate) {
            if (newPersonEntity.getPESEL() == null) {
                newPersonEntity.setPESEL(personEntityToUpdate.getPESEL());
            }
        }

        return repository.save(newContact);
    }

    public void deleteContact(Long id) {
        repository.deleteById(id);
    }
}
