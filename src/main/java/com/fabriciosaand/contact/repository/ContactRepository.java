package com.fabriciosaand.contact.repository;

import com.fabriciosaand.contact.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    Optional<Contact> findByName(String name);

    Optional<Contact> findByNumber(String number);

}
