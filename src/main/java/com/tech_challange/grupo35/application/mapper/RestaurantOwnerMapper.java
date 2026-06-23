package com.tech_challange.grupo35.application.mapper;

import com.tech_challange.grupo35.application.dto.CreateRestaurantOwnerRequest;
import com.tech_challange.grupo35.application.dto.UpdateRestaurantOwnerRequest;
import com.tech_challange.grupo35.domain.model.RestaurantOwner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RestaurantOwnerMapper {

    public RestaurantOwner toModel(CreateRestaurantOwnerRequest request) {
        return RestaurantOwner.create(
                request.name(),
                request.email(),
                request.login(),
                request.password(),
                request.address(),
                request.cnpj());
    }

    public RestaurantOwner updateModel(RestaurantOwner current, UpdateRestaurantOwnerRequest request) {
        return new RestaurantOwner(
                current.getId(),
                request.name() != null ? request.name() : current.getName(),
                request.email() != null ? request.email() : current.getEmail(),
                request.login() != null ? request.login() : current.getLogin(),
                current.getPassword(),
                request.address() != null ? request.address() : current.getAddress(),
                LocalDateTime.now(),
                current.getUserType(),
                request.cnpj() != null ? request.cnpj() : current.getCnpj());
    }
}
