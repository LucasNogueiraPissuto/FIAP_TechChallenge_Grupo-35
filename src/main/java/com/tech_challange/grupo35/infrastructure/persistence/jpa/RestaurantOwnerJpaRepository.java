package com.tech_challange.grupo35.infrastructure.persistence.jpa;

import com.tech_challange.grupo35.infrastructure.persistence.entity.RestaurantOwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RestaurantOwnerJpaRepository extends JpaRepository<RestaurantOwnerEntity, UUID> {
    boolean existsByCnpj(String cnpj);
}
