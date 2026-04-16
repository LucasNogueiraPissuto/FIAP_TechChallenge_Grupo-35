package com.tech_challange.grupo35.user.repository;

import com.tech_challange.grupo35.user.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {

    boolean existsByCpf(String cpf);
}
