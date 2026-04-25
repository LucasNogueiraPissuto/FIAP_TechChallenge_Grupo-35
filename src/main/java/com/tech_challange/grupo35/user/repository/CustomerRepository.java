package com.tech_challange.grupo35.user.repository;

import com.tech_challange.grupo35.user.entity.CustomerEntity;
import com.tech_challange.grupo35.user.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository {

    Optional<CustomerEntity> findById(UUID id);
    boolean existsByCpf(String cpf);
    UserEntity save(CustomerEntity customerEntity);
}
