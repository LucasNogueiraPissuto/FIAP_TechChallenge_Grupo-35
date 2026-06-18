package com.tech_challange.grupo35.domain.repository;

import com.tech_challange.grupo35.domain.model.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {
    Optional<Customer> findById(UUID id);
    Customer save(Customer customer);
    boolean existsByCpf(String cpf);
}
