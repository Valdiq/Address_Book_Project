package org.vladstasyshyn.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.vladstasyshyn.logging.implementation.LogApiCall;
import org.vladstasyshyn.mapper.ContactModelMapper;
import org.vladstasyshyn.model.dto.request.ContactRequestDTO;
import org.vladstasyshyn.model.dto.response.ContactResponseDTO;
import org.vladstasyshyn.model.entity.ContactEntity;
import org.vladstasyshyn.security.roleaccess.AdminRoleAccess;
import org.vladstasyshyn.security.roleaccess.AnyRoleAccess;
import org.vladstasyshyn.service.ContactService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
@RequestMapping("/api")

public class ContactController {

    private final ContactService service;

    private final ContactModelMapper modelMapper;

    @LogApiCall
    @AnyRoleAccess
    @GetMapping("/contacts/{id}")
    public ContactResponseDTO getContact(@PathVariable Long id) {

        return modelMapper.mapContactEntityToContactResponseDTO(service.getContact(id));
    }

    @LogApiCall
    @AnyRoleAccess
    @GetMapping("/contacts")
    public List<ContactResponseDTO> getAllContacts() {
        List<ContactEntity> contactResponseDTOList = service.getAllContacts().get();
        return contactResponseDTOList.stream()
                .map(modelMapper::mapContactEntityToContactResponseDTO)
                .toList();
    }

    @LogApiCall
    @AnyRoleAccess
    @GetMapping("/contacts/page")
    public List<ContactResponseDTO> getContactPage(@RequestParam(name = "nr") int pageNumber, @RequestParam(name = "size") int pageSize) {
        Page<ContactEntity> entityPage = service.getContactPage(pageNumber, pageSize);
        return entityPage.stream()
                .map(modelMapper::mapContactEntityToContactResponseDTO)
                .toList();
    }

    @LogApiCall
    @AnyRoleAccess
    @PostMapping("/contacts")
    public ContactResponseDTO createContact(@RequestBody ContactRequestDTO contactRequestDTO) {
        return modelMapper.mapContactEntityToContactResponseDTO(
                service.createContact(
                        modelMapper.mapContactRequestDTOToContactDAO(contactRequestDTO)
                )
        );
    }

    @LogApiCall
    @AnyRoleAccess
    @PutMapping("/contacts/{id}")
    public ContactResponseDTO updateContact(@PathVariable Long id, @RequestBody ContactRequestDTO contactRequestDTO) {
        return modelMapper.mapContactEntityToContactResponseDTO(
                service.updateContact(
                        id, modelMapper.mapContactRequestDTOToContactDAO(contactRequestDTO)
                )
        );
    }

    @LogApiCall
    @AdminRoleAccess
    @DeleteMapping("/contacts/{id}")
    public void deleteContact(@PathVariable Long id) {
        service.deleteContact(id);
    }
}
