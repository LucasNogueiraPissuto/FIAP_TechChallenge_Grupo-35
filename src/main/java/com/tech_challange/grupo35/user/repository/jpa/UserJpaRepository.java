package com.tech_challange.grupo35.user.repository.jpa;

import com.tech_challange.grupo35.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {
    boolean existsByEmail(String email);
    boolean existsByLogin(String login);
    List<UserEntity> findByNameContainingIgnoreCase(String name);
    Optional<UserEntity> findByLogin(String login);
}
