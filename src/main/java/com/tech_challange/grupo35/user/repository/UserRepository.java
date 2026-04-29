package com.tech_challange.grupo35.user.repository;

import com.tech_challange.grupo35.user.entity.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    Optional<UserEntity> findById(UUID id);
    boolean existsByEmail(String email);
    boolean existsByLogin(String login);
    boolean existsById(UUID id);
    UserEntity save(UserEntity user);
    List<UserEntity> findByNameContainingIgnoreCase(String name);
    Optional<UserEntity> findByLogin(String login);
    void deleteById(UUID id);
}
