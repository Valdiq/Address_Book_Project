package org.vlad_stasyshyn.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.vlad_stasyshyn.mapper.ContactModelMapper;
import org.vlad_stasyshyn.model.dto.request.ContactRequestDTO;
import org.vlad_stasyshyn.model.dto.response.ContactResponseDTO;
import org.vlad_stasyshyn.model.entity.ContactEntity;
import org.vlad_stasyshyn.service.ContactService;

import java.util.List;

@RestController
@Validated
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
    public ContactResponseDTO createContact(@RequestBody @Valid ContactRequestDTO contactRequestDTO) {
        return modelMapper.mapContactEntityToContactResponseDTO(
                service.createContact(
                        modelMapper.mapContactRequestDTOToContactDAO(contactRequestDTO)
                )
        );
    }

    @PutMapping("/contacts/{id}")
    public ContactResponseDTO updateContact(@PathVariable Long id, @RequestBody @Valid ContactRequestDTO contactRequestDTO) {
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
