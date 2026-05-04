package com.tech_challange.grupo35.user.mapper;

import com.tech_challange.grupo35.user.dto.CreateRestaurantOwnerRequest;
import com.tech_challange.grupo35.user.dto.UpdateRestaurantOwnerRequest;
import com.tech_challange.grupo35.user.entity.RestaurantOwnerEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class RestaurantOwnerMapper {

    public RestaurantOwnerEntity toEntity(CreateRestaurantOwnerRequest request) {
        RestaurantOwnerEntity owner = new RestaurantOwnerEntity();
        owner.setName(request.name());
        owner.setEmail(request.email());
        owner.setLogin(request.login());
        owner.setAddress(request.address());
        owner.setCnpj(request.cnpj());
        owner.setLastUpdatedAt(LocalDateTime.now());
        return owner;
    }

    public void updateEntity(RestaurantOwnerEntity entity, UpdateRestaurantOwnerRequest request) {
        Optional.ofNullable(request.name()).ifPresent(entity::setName);
        Optional.ofNullable(request.email()).ifPresent(entity::setEmail);
        Optional.ofNullable(request.login()).ifPresent(entity::setLogin);
        Optional.ofNullable(request.address()).ifPresent(entity::setAddress);
        Optional.ofNullable(request.cnpj()).ifPresent(entity::setCnpj);
        entity.setLastUpdatedAt(LocalDateTime.now());
    }
}
