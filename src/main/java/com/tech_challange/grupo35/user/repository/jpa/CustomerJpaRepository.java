package com.tech_challange.grupo35.user.repository.jpa;

import com.tech_challange.grupo35.user.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, UUID> {
    boolean existsByCpf(String cpf);
}
