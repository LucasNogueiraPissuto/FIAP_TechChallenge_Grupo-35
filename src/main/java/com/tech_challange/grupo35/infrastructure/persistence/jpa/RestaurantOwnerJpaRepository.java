package com.tech_challange.grupo35.infrastructure.persistence.jpa;

import com.tech_challange.grupo35.domain.model.RestaurantOwner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RestaurantOwnerJpaRepository extends JpaRepository<RestaurantOwner, UUID> {
    boolean existsByCnpj(String cnpj);
}
