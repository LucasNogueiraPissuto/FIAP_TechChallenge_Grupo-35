package com.tech_challange.grupo35.application.mapper;

import com.tech_challange.grupo35.application.dto.CreateRestaurantOwnerRequest;
import com.tech_challange.grupo35.application.dto.UpdateRestaurantOwnerRequest;
import com.tech_challange.grupo35.domain.model.RestaurantOwner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RestaurantOwnerMapper {

    public RestaurantOwner toModel(CreateRestaurantOwnerRequest request) {
        RestaurantOwner owner = new RestaurantOwner();
        owner.setName(request.name());
        owner.setEmail(request.email());
        owner.setLogin(request.login());
        owner.setPassword(request.password());
        owner.setAddress(request.address());
        owner.setCnpj(request.cnpj());
        owner.setLastUpdatedAt(LocalDateTime.now());
        return owner;
    }

    public RestaurantOwner updateModel(RestaurantOwner current, UpdateRestaurantOwnerRequest request) {
        if (request.name() != null) current.setName(request.name());
        if (request.email() != null) current.setEmail(request.email());
        if (request.login() != null) current.setLogin(request.login());
        if (request.address() != null) current.setAddress(request.address());
        if (request.cnpj() != null) current.setCnpj(request.cnpj());
        current.setLastUpdatedAt(LocalDateTime.now());
        return current;
    }
}
