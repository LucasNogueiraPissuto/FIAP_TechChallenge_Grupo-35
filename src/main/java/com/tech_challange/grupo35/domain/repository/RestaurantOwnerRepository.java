package com.tech_challange.grupo35.domain.repository;

import com.tech_challange.grupo35.domain.model.RestaurantOwner;

import java.util.Optional;
import java.util.UUID;

public interface RestaurantOwnerRepository {
    Optional<RestaurantOwner> findById(UUID id);
    RestaurantOwner save(RestaurantOwner owner);
    boolean existsByCnpj(String cnpj);
}
