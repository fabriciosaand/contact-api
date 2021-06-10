package com.fabriciosaand.contact.service;

import com.fabriciosaand.contact.model.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    public List<Contact> getContacts(){
        return java.util.List.of(
                new com.fabriciosaand.contact.model.Contact("Fabricio", "Fabricio Andrade", "009900"),
                new com.fabriciosaand.contact.model.Contact("João", "João Andrade", "123456"));
    }
}
