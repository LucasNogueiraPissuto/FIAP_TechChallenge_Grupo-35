package com.tech_challange.grupo35.user.repository;

import com.tech_challange.grupo35.user.entity.RestaurantOwnerEntity;
import com.tech_challange.grupo35.user.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RestaurantOwnerRepository{

    Optional<RestaurantOwnerEntity> findById(UUID id);
    boolean existsByCnpj(String cnpj);
    UserEntity save(RestaurantOwnerEntity restaurantOwnerEntity);
}
