package com.fabriciosaand.contact.repository;

import com.fabriciosaand.contact.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
