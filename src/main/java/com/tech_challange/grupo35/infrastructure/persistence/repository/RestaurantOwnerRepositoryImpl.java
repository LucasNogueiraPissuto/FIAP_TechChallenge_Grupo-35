package com.tech_challange.grupo35.infrastructure.persistence.repository;

import com.tech_challange.grupo35.domain.model.RestaurantOwner;
import com.tech_challange.grupo35.domain.repository.RestaurantOwnerRepository;
import com.tech_challange.grupo35.infrastructure.persistence.jpa.RestaurantOwnerJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class RestaurantOwnerRepositoryImpl implements RestaurantOwnerRepository {

    private final RestaurantOwnerJpaRepository jpaRepository;

    @Override
    public Optional<RestaurantOwner> findById(UUID id) {
        return jpaRepository.findById(id);
    }

    @Override
    public RestaurantOwner save(RestaurantOwner owner) {
        return jpaRepository.save(owner);
    }

    @Override
    public boolean existsByCnpj(String cnpj) {
        return jpaRepository.existsByCnpj(cnpj);
    }
}
