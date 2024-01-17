package org.vlad_stasyshyn;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vlad_stasyshyn.model.entity.ContactEntity;
import org.vlad_stasyshyn.service.ContactService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")

public class testController {

    private final ContactService service;


    @GetMapping("/contacts/{id}")
    public ResponseEntity<ContactEntity> getContact(@PathVariable Long id) {
        ResponseEntity<ContactEntity> responseEntity = new ResponseEntity<>(service.getContact(id), HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/contacts")
    public ResponseEntity<List<ContactEntity>> getAllContacts() {
        Optional<List<ContactEntity>> entityList = service.getAllContacts();
        ResponseEntity<List<ContactEntity>> responseEntityList = new ResponseEntity<>(entityList.get(), HttpStatus.OK);
        return responseEntityList;
    }

    @PostMapping("/contacts")
    public ResponseEntity<ContactEntity> createContact(@RequestBody ContactEntity contact) {
        ContactEntity entity = service.createContact(contact);
        ResponseEntity<ContactEntity> responseEntity = new ResponseEntity<>(entity, HttpStatus.CREATED);
        return responseEntity;
    }

    @PutMapping("/contacts/{id}")
    public ResponseEntity<ContactEntity> updateContact(@PathVariable Long id) {
        ContactEntity entityToUpdate = service.getContact(id);
        ContactEntity newEntity = service.updateContact(entityToUpdate);
        ResponseEntity<ContactEntity> responseEntity = new ResponseEntity<>(newEntity, HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/contacts/{id}")
    public void deleteContact(@PathVariable Long id) {
        service.deleteContact(id);
    }
}
