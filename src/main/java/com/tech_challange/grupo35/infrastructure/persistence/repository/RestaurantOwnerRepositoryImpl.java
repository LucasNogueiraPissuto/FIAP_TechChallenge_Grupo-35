package com.tech_challange.grupo35.infrastructure.persistence.repository;

import com.tech_challange.grupo35.domain.model.RestaurantOwner;
import com.tech_challange.grupo35.application.port.out.RestaurantOwnerRepository;
import com.tech_challange.grupo35.infrastructure.persistence.jpa.RestaurantOwnerJpaRepository;
import com.tech_challange.grupo35.infrastructure.persistence.mapper.RestaurantOwnerEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class RestaurantOwnerRepositoryImpl implements RestaurantOwnerRepository {

    private final RestaurantOwnerJpaRepository jpaRepository;
    private final RestaurantOwnerEntityMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public Optional<RestaurantOwner> findById(UUID id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    @Transactional
    public RestaurantOwner save(RestaurantOwner owner) {
        return mapper.toDomain(jpaRepository.save(mapper.toEntity(owner)));
    }

    @Override
    public boolean existsByCnpj(String cnpj) {
        return jpaRepository.existsByCnpj(cnpj);
    }
}
