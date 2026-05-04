package com.tech_challange.grupo35.user.repository.impl;

import com.tech_challange.grupo35.user.entity.RestaurantOwnerEntity;
import com.tech_challange.grupo35.user.repository.RestaurantOwnerRepository;
import com.tech_challange.grupo35.user.repository.jpa.RestaurantOwnerJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class RestaurantOwnerRepositoryImpl implements RestaurantOwnerRepository {
    private final RestaurantOwnerJpaRepository jpaRepository;

    @Override
    public Optional<RestaurantOwnerEntity> findById(UUID id) {
        return jpaRepository.findById(id);
    }

    @Override
    public RestaurantOwnerEntity save(RestaurantOwnerEntity owner) {
        return jpaRepository.save(owner);
    }

    @Override
    public boolean existsByCnpj(String cnpj) {
        return jpaRepository.existsByCnpj(cnpj);
    }
}
