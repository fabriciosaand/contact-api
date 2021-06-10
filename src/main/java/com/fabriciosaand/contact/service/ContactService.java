package com.fabriciosaand.contact.service;

import com.fabriciosaand.contact.dto.request.ContactDTO;
import com.fabriciosaand.contact.mapper.ContactMapper;
import com.fabriciosaand.contact.model.Contact;
import com.fabriciosaand.contact.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ContactService {

    private final ContactRepository contactRepository;

    private static final ContactMapper contactMapper = ContactMapper.INSTANCE;

    public List<Contact> getContacts(){
        return contactRepository.findAll();
    }

    public void addContact(ContactDTO contactDTO) {
        var contactToSave = contactMapper.contactDTOtoContact(contactDTO);
        contactRepository.save(contactToSave);
    }
}
