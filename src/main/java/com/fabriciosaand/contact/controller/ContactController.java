package com.fabriciosaand.contact.controller;

import com.fabriciosaand.contact.model.Contact;
import com.fabriciosaand.contact.requests.ContactPostRequestBody;
import com.fabriciosaand.contact.requests.ContactPutRequestBody;
import com.fabriciosaand.contact.service.ContactService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/contact")
@RequiredArgsConstructor
@Log4j2
public class ContactController {

    private final ContactService contactService;

    @GetMapping
    public List<Contact> getContacts(){
        return contactService.listAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Contact> findById(@PathVariable long id){
        return ResponseEntity.ok(contactService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Contact> save(@RequestBody ContactPostRequestBody contactPostRequestBody,
                                        @AuthenticationPrincipal UserDetails userDetails){
        log.info(userDetails);
        return new ResponseEntity<>(contactService.save(contactPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        contactService.delete(id);
    }

    @PutMapping()
    public ResponseEntity<Void> replace(@RequestBody ContactPutRequestBody contactPutRequestBody){
        contactService.replace(contactPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
