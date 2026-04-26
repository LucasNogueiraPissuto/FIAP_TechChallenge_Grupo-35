package com.tech_challange.grupo35.user.repository.impl;

import com.tech_challange.grupo35.user.entity.CustomerEntity;
import com.tech_challange.grupo35.user.repository.CustomerRepository;
import com.tech_challange.grupo35.user.repository.jpa.CustomerJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerJpaRepository jpaRepository;

    @Override
    public Optional<CustomerEntity> findById(UUID id) {
        return jpaRepository.findById(id);
    }

    @Override
    public CustomerEntity save(CustomerEntity customer) {
        return jpaRepository.save(customer);
    }

    @Override
    public boolean existsByCpf(String cpf) {
        return jpaRepository.existsByCpf(cpf);
    }
}
