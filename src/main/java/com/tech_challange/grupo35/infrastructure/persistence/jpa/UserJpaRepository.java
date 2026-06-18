package com.tech_challange.grupo35.infrastructure.persistence.jpa;

import com.tech_challange.grupo35.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<User, UUID> {
    boolean existsByEmail(String email);
    boolean existsByLogin(String login);
    List<User> findByNameContainingIgnoreCase(String name);
    Optional<User> findByLogin(String login);
}
