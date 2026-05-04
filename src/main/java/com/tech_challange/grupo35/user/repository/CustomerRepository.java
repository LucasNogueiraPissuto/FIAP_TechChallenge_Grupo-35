package com.tech_challange.grupo35.user.repository;

import com.tech_challange.grupo35.user.entity.CustomerEntity;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {
    Optional<CustomerEntity> findById(UUID id);
    CustomerEntity save(CustomerEntity customer);
    boolean existsByCpf(String cpf);
}
