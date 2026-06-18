package com.tech_challange.grupo35.infrastructure.persistence.jpa;

import com.tech_challange.grupo35.domain.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserTypeJpaRepository extends JpaRepository<UserType, UUID> {
    boolean existsByName(String name);
}
