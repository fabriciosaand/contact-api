package com.fabriciosaand.contact.repository;

import com.fabriciosaand.contact.model.Contact;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
@DisplayName("Tests for Contact Repository")
class ContactRepositoryTest {

    @Autowired
    private ContactRepository contactRepository;

    @Test
    @DisplayName("Save creates contact when Successful")
    void save_PersistContact_WhenSuccessful(){
        Contact contactToBeSaved = createContact();

        Contact contactSaved = this.contactRepository.save(contactToBeSaved);

        Assertions.assertThat(contactSaved).isNotNull();

        Assertions.assertThat(contactSaved.getId()).isNotNull();

        Assertions.assertThat(contactSaved.getName()).isEqualTo(contactToBeSaved.getName());

        Assertions.assertThat(contactSaved.getDescription()).isEqualTo(contactToBeSaved.getDescription());

        Assertions.assertThat(contactSaved.getNumber()).isEqualTo(contactToBeSaved.getNumber());

    }

    @Test
    @DisplayName("Save updates contact when Successful")
    void save_UpdatesContact_WhenSuccessful(){
        Contact contactToBeSaved = createContact();

        Contact contactSaved = this.contactRepository.save(contactToBeSaved);

        contactSaved.setName("Overlord");
        contactSaved.setDescription("Overlord");
        contactSaved.setNumber("Overlord");

        Contact contactUpdated = this.contactRepository.save(contactSaved);

        Assertions.assertThat(contactUpdated).isNotNull();

        Assertions.assertThat(contactUpdated.getId()).isNotNull();

        Assertions.assertThat(contactUpdated.getName()).isEqualTo(contactSaved.getName());

        Assertions.assertThat(contactUpdated.getDescription()).isEqualTo(contactSaved.getDescription());

        Assertions.assertThat(contactUpdated.getNumber()).isEqualTo(contactSaved.getNumber());

    }

    @Test
    @DisplayName("Delete removes contact when Successful")
    void delete_RemovesContact_WhenSuccessful(){
        Contact contactToBeSaved = createContact();

        Contact contactSaved = this.contactRepository.save(contactToBeSaved);

        this.contactRepository.delete(contactSaved);

        Optional<Contact> contactOptional = this.contactRepository.findById(contactSaved.getId());

        Assertions.assertThat(contactOptional).isEmpty();

    }

    @Test
    @DisplayName("Find By name returns contact when Successful")
    void findByName_ReturnsContact_WhenSuccessful(){
        Contact contactToBeSaved = createContact();

        Contact contactSaved = this.contactRepository.save(contactToBeSaved);

        String name = contactSaved.getName();

        Optional<Contact> contactOptional = this.contactRepository.findByName(name);

        Assertions.assertThat(contactOptional).isNotEmpty();

        Assertions.assertThat(contactOptional.get().getName()).isEqualTo(name);

    }

    @Test
    @DisplayName("Find By name returns empty when when no contact is found")
    void findByName_ReturnsEmpty_WhenContactIsNotFound(){
        Optional<Contact> contactOptional = this.contactRepository.findByName("xaxa");

        Assertions.assertThat(contactOptional).isEmpty();

    }

    private Contact createContact(){
        return Contact.builder()
                .name("Fabricio Andrade")
                .description("Fabricio Santiago Andrade")
                .number("1234")
                .build();
    }

}