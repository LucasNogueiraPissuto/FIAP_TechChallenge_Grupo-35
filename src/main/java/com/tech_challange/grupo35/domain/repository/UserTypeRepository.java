package com.tech_challange.grupo35.domain.repository;

import com.tech_challange.grupo35.domain.model.UserType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserTypeRepository {
    UserType save(UserType userType);
    Optional<UserType> findById(UUID id);
    List<UserType> findAll();
    void deleteById(UUID id);
    boolean existsById(UUID id);
    boolean existsByName(String name);
}
