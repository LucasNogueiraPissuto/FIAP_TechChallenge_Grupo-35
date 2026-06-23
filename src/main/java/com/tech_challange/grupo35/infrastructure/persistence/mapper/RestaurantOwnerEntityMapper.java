package com.tech_challange.grupo35.infrastructure.persistence.mapper;

import com.tech_challange.grupo35.domain.model.RestaurantOwner;
import com.tech_challange.grupo35.infrastructure.persistence.entity.RestaurantOwnerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestaurantOwnerEntityMapper {

    private final UserTypeEntityMapper userTypeMapper;

    public RestaurantOwner toDomain(RestaurantOwnerEntity entity) {
        if (entity == null) {
            return null;
        }
        return new RestaurantOwner(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getLogin(),
                entity.getPassword(),
                entity.getAddress(),
                entity.getLastUpdatedAt(),
                userTypeMapper.toDomain(entity.getUserType()),
                entity.getCnpj());
    }

    public RestaurantOwnerEntity toEntity(RestaurantOwner domain) {
        if (domain == null) {
            return null;
        }
        RestaurantOwnerEntity entity = new RestaurantOwnerEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        entity.setEmail(domain.getEmail());
        entity.setLogin(domain.getLogin());
        entity.setPassword(domain.getPassword());
        entity.setAddress(domain.getAddress());
        entity.setLastUpdatedAt(domain.getLastUpdatedAt());
        entity.setUserType(userTypeMapper.toEntity(domain.getUserType()));
        entity.setCnpj(domain.getCnpj());
        return entity;
    }
}
