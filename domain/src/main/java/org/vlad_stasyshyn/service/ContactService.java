package org.vlad_stasyshyn.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vlad_stasyshyn.mapper.ContactEntityDAOMapper;
import org.vlad_stasyshyn.model.dao.ContactDAO;
import org.vlad_stasyshyn.model.entity.CompanyEntity;
import org.vlad_stasyshyn.model.entity.ContactEntity;
import org.vlad_stasyshyn.model.entity.PersonEntity;
import org.vlad_stasyshyn.repository.ContactRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository repository;

    private final ContactEntityDAOMapper contactEntityDAOMapper;


    public ContactEntity getContact(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact Not Found"));
    }

    public Optional<List<ContactEntity>> getAllContacts() {
        return Optional.ofNullable(Optional.of(repository.findAll())
                .orElseThrow(() -> new RuntimeException("No Contacts Found")));
    }


    public ContactEntity createContact(ContactDAO contactDAO) {
        return repository.save(contactEntityDAOMapper.mapContactDAOToContactEntity(contactDAO));
    }

    public ContactEntity updateContact(Long id, ContactDAO contactDAO) {

        var contactToUpdate = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No Contact Found"));

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
