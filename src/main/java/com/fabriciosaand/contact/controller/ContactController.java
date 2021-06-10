package com.fabriciosaand.contact.controller;

import com.fabriciosaand.contact.dto.request.ContactDTO;
import com.fabriciosaand.contact.model.Contact;
import com.fabriciosaand.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/contact")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService){
        this.contactService = contactService;
    }

    @GetMapping
    public List<Contact> getContacts(){
        return contactService.getContacts();
    }

    @PostMapping
    public void createContact(@RequestBody ContactDTO contact){
        contactService.addContact(contact);
    }

}
