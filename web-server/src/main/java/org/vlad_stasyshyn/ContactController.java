package org.vlad_stasyshyn;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.vlad_stasyshyn.mapper.ContactModelMapper;
import org.vlad_stasyshyn.model.dto.request.ContactRequestDTO;
import org.vlad_stasyshyn.model.dto.response.ContactResponseDTO;
import org.vlad_stasyshyn.model.entity.ContactEntity;
import org.vlad_stasyshyn.service.ContactService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")

public class ContactController {

    private final ContactService service;

    private final ContactModelMapper modelMapper;


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ContactResponseDTO.class))
            })
    })
    @GetMapping("/contacts/{id}")
    public ContactResponseDTO getContact(@PathVariable Long id) {
        return modelMapper.mapContactEntityToContactResponseDTO(service.getContact(id));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ContactResponseDTO.class))
            })
    })
    @GetMapping("/contacts")
    public List<ContactResponseDTO> getAllContacts() {
        List<ContactEntity> contactResponseDTOList = service.getAllContacts().get();
        return contactResponseDTOList.stream()
                .map(modelMapper::mapContactEntityToContactResponseDTO)
                .toList();
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ContactResponseDTO.class))
            })
    })
    @PostMapping("/contacts")
    public ContactResponseDTO createContact(@RequestBody ContactRequestDTO contactRequestDTO) {
        return modelMapper.mapContactEntityToContactResponseDTO(
                service.createContact(
                        modelMapper.mapContactRequestDTOToContactDAO(contactRequestDTO)
                )
        );
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ContactResponseDTO.class))
            })
    })
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
