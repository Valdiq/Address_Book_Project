package org.vladstasyshyn.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.vladstasyshyn.exceptionhandling.ContactNotFoundException;
import org.vladstasyshyn.mapper.ContactEntityDAOMapper;
import org.vladstasyshyn.model.dao.ContactDAO;
import org.vladstasyshyn.model.entity.CompanyEntity;
import org.vladstasyshyn.model.entity.ContactDetailsEntity;
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

    private final ContactDetailsService detailsService;

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

    @Transactional(readOnly = true)
    public Page<ContactEntity> getContactPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return repository.findAll(pageable);
    }

    public ContactEntity createContact(@Valid ContactDAO contactDAO) {
        var newContact = contactEntityDAOMapper.mapContactDAOToContactEntity(contactDAO);
        newContact.setContactDetails(new ContactDetailsEntity()
                .setPhone(contactDAO.getPhone())
                .setEmail(contactDAO.getEmail())
                .setContactEntity(newContact));
        return repository.save(newContact);
    }

    public ContactEntity updateContact(Long id, @Valid ContactDAO contactDAO) {

        var contactToUpdate = repository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException(id));

        var contactDetails = detailsService.findByContactEntityId(id)
                .orElseThrow(() -> new RuntimeException("Contact Details Not Found"));

        var newContact = contactEntityDAOMapper.mapContactDAOToContactEntity(contactDAO)
                .setId(contactToUpdate.getId()); // <-- setting ID from ContactDAO to ContactEntity automatically by mapper(mapstruct) doesn't work for some reason.
        // Will be fixed in final debug branch in future (when I'll figure it out wtf it's going wrong with it lol) :)


        var newContactDetails = new ContactDetailsEntity()
                .setId(contactDetails.getId())
                .setPhone(contactDAO.getPhone())
                .setEmail(contactDAO.getEmail())
                .setContactEntity(newContact);

        newContact.setContactDetails(newContactDetails);

        setDefaultValuesForNullFields(newContact, contactToUpdate);

        return repository.save(newContact);
    }

    public void deleteContact(Long id) {
        repository.deleteById(id);
    }

    private void setDefaultValuesForNullFields(ContactEntity newContact, ContactEntity oldContact) {
        if (newContact instanceof CompanyEntity newCompanyEntity
                && oldContact instanceof CompanyEntity oldCompany) {
            if (newCompanyEntity.getNIP() == null) {
                newCompanyEntity.setNIP(oldCompany.getNIP());
            }
        }

        if (newContact instanceof PersonEntity newPersonEntity
                && oldContact instanceof PersonEntity oldPerson) {
            if (newPersonEntity.getPESEL() == null) {
                newPersonEntity.setPESEL(oldPerson.getPESEL());
            }
        }

        if (newContact.getContactDetails().getPhone() == null) {
            var oldContactDetails = oldContact.getContactDetails();
            newContact.getContactDetails().setPhone(oldContactDetails.getPhone());
        }
    }
}
