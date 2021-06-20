package com.fabriciosaand.contact.service;

import com.fabriciosaand.contact.exception.BadRequestException;
import com.fabriciosaand.contact.mapper.ContactMapper;
import com.fabriciosaand.contact.model.Contact;
import com.fabriciosaand.contact.repository.ContactRepository;
import com.fabriciosaand.contact.requests.ContactPostRequestBody;
import com.fabriciosaand.contact.requests.ContactPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    private static final ContactMapper contactMapper = ContactMapper.INSTANCE;

    public List<Contact> listAll(){
        return contactRepository.findAll();
    }

    public Contact findByIdOrThrowBadRequestException(long id){
        return contactRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Contact not found"));
    }

    public Contact save(ContactPostRequestBody contactPostRequestBody) {
        Contact contact = ContactMapper.INSTANCE.toContact(contactPostRequestBody);
        var contactOptional = contactRepository.findByName(contact.getName());
        var contactSameNumber = contactRepository.findByNumber(contact.getNumber());
        if (contactOptional.isPresent()){
            throw new IllegalStateException("name already exists");
        }

        if (contactSameNumber.isPresent()){
            throw new IllegalStateException("number already exists");
        }

        return contactRepository.save(contact);
    }

    public void delete(long id) {
        contactRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(ContactPutRequestBody contactPutRequestBody) {
        findByIdOrThrowBadRequestException(contactPutRequestBody.getId());
        Contact contact = ContactMapper.INSTANCE.toContact(contactPutRequestBody);
        contactRepository.save(contact);
    }
}
