package com.tech_challange.grupo35.application.mapper;

import com.tech_challange.grupo35.application.dto.CreateRestaurantOwnerRequest;
import com.tech_challange.grupo35.application.dto.UpdateRestaurantOwnerRequest;
import com.tech_challange.grupo35.domain.model.RestaurantOwner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class RestaurantOwnerMapper {

    public RestaurantOwner toModel(CreateRestaurantOwnerRequest request) {
        RestaurantOwner owner = new RestaurantOwner();
        owner.setName(request.name());
        owner.setEmail(request.email());
        owner.setLogin(request.login());
        owner.setAddress(request.address());
        owner.setCnpj(request.cnpj());
        owner.setLastUpdatedAt(LocalDateTime.now());
        return owner;
    }

    public void updateModel(RestaurantOwner owner, UpdateRestaurantOwnerRequest request) {
        Optional.ofNullable(request.name()).ifPresent(owner::setName);
        Optional.ofNullable(request.email()).ifPresent(owner::setEmail);
        Optional.ofNullable(request.login()).ifPresent(owner::setLogin);
        Optional.ofNullable(request.address()).ifPresent(owner::setAddress);
        Optional.ofNullable(request.cnpj()).ifPresent(owner::setCnpj);
        owner.setLastUpdatedAt(LocalDateTime.now());
    }
}
