package com.fabriciosaand.contact.controller;

import com.fabriciosaand.contact.model.Contact;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/contact")
public class ContactController {

    @GetMapping
    public List<Contact> getContacts(){
        return List.of(
                new Contact("Fabricio", "Fabricio Andrade", "009900"),
                new Contact("João", "João Andrade", "123456"));
    }
}
