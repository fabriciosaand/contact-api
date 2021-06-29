package com.fabriciosaand.contact.config;

import com.fabriciosaand.contact.model.User;
import com.fabriciosaand.contact.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner createUsers(UserRepository userRepository){
        return args -> {
            User fabricio = new User(
                    1L,
                    "Fabricio Andrade",
                    "fabricio",
                    "{bcrypt}$2a$10$Ga1Yj.wPOvg5BwfyKNy46eB316Zbp9g75bb7InN5bZKFWu3o3qx0u",
                    "ROLE_ADMIN,ROLE_USER");
            User joao = new User(
                    2L,
                    "João Andrade",
                    "joao",
                    "{bcrypt}$2a$10$Ga1Yj.wPOvg5BwfyKNy46eB316Zbp9g75bb7InN5bZKFWu3o3qx0u",
                    "ROLE_USER");

            userRepository.saveAll(List.of(fabricio, joao));
        };
    }
}
