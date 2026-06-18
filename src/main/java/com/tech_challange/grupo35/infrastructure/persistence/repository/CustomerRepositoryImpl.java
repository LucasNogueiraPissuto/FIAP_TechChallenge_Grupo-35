package com.tech_challange.grupo35.infrastructure.persistence.repository;

import com.tech_challange.grupo35.domain.model.Customer;
import com.tech_challange.grupo35.domain.repository.CustomerRepository;
import com.tech_challange.grupo35.infrastructure.persistence.jpa.CustomerJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerJpaRepository jpaRepository;

    @Override
    public Optional<Customer> findById(UUID id) {
        return jpaRepository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return jpaRepository.save(customer);
    }

    @Override
    public boolean existsByCpf(String cpf) {
        return jpaRepository.existsByCpf(cpf);
    }
}
