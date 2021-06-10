package com.fabriciosaand.contact.config;

import com.fabriciosaand.contact.model.Contact;
import com.fabriciosaand.contact.repository.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ContactConfig {

    @Bean
    CommandLineRunner commandLineRunner(ContactRepository contactRepository){
        return args -> {
            Contact fabricio = new Contact(
                    1L,
                    "Fabricio",
                    "Fabricio Andrade",
                    "1234");
            Contact joao = new Contact(
                    2L,
                    "João",
                    "João Andrade",
                    "1234");

            contactRepository.saveAll(List.of(fabricio, joao));
        };
    }
}
