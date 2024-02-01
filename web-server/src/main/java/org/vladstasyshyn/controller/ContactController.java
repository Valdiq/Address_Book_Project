package org.vladstasyshyn.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.vladstasyshyn.mapper.ContactModelMapper;
import org.vladstasyshyn.model.dto.request.ContactRequestDTO;
import org.vladstasyshyn.model.dto.response.ContactResponseDTO;
import org.vladstasyshyn.model.entity.ContactEntity;
import org.vladstasyshyn.service.ContactService;

import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("/api")

public class ContactController {

    private final ContactService service;

    private final ContactModelMapper modelMapper;

    @GetMapping("/contacts/{id}")
    public ContactResponseDTO getContact(@PathVariable Long id) {
        return modelMapper.mapContactEntityToContactResponseDTO(service.getContact(id));
    }

    @GetMapping("/contacts")
    public List<ContactResponseDTO> getAllContacts() {
        List<ContactEntity> contactResponseDTOList = service.getAllContacts().get();
        return contactResponseDTOList.stream()
                .map(modelMapper::mapContactEntityToContactResponseDTO)
                .toList();
    }

    @PostMapping("/contacts")
    public ContactResponseDTO createContact(@RequestBody ContactRequestDTO contactRequestDTO) {
        return modelMapper.mapContactEntityToContactResponseDTO(
                service.createContact(
                        modelMapper.mapContactRequestDTOToContactDAO(contactRequestDTO)
                )
        );
    }

    @PutMapping("/contacts/{id}")
    public ContactResponseDTO updateContact(@PathVariable Long id, @RequestBody ContactRequestDTO contactRequestDTO) {
        return modelMapper.mapContactEntityToContactResponseDTO(
                service.updateContact(
                        id, modelMapper.mapContactRequestDTOToContactDAO(contactRequestDTO)
                )
        );
    }

    @DeleteMapping("/contacts/{id}")
    public void deleteContact(@PathVariable Long id) {
        service.deleteContact(id);
    }
}
