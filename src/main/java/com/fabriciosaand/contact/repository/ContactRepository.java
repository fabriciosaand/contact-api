package com.fabriciosaand.contact.repository;

import com.fabriciosaand.contact.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
