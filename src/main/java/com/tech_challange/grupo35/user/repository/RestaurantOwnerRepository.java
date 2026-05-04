package com.tech_challange.grupo35.user.repository;

import com.tech_challange.grupo35.user.entity.RestaurantOwnerEntity;

import java.util.Optional;
import java.util.UUID;

public interface RestaurantOwnerRepository {
    Optional<RestaurantOwnerEntity> findById(UUID id);
    RestaurantOwnerEntity save(RestaurantOwnerEntity owner);
    boolean existsByCnpj(String cnpj);
}
