package com.tech_challange.grupo35.infrastructure.persistence.jpa;

import com.tech_challange.grupo35.infrastructure.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, UUID> {
    boolean existsByCpf(String cpf);
}
