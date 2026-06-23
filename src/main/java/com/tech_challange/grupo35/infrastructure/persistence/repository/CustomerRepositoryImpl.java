package com.tech_challange.grupo35.infrastructure.persistence.repository;

import com.tech_challange.grupo35.domain.model.Customer;
import com.tech_challange.grupo35.domain.repository.CustomerRepository;
import com.tech_challange.grupo35.infrastructure.persistence.jpa.CustomerJpaRepository;
import com.tech_challange.grupo35.infrastructure.persistence.mapper.CustomerEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerJpaRepository jpaRepository;
    private final CustomerEntityMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public Optional<Customer> findById(UUID id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    @Transactional
    public Customer save(Customer customer) {
        return mapper.toDomain(jpaRepository.save(mapper.toEntity(customer)));
    }

    @Override
    public boolean existsByCpf(String cpf) {
        return jpaRepository.existsByCpf(cpf);
    }
}
