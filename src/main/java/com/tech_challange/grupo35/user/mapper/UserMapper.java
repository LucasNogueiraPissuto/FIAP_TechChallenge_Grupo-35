package com.tech_challange.grupo35.user.mapper;

import com.tech_challange.grupo35.user.dto.*;
import com.tech_challange.grupo35.user.entity.CustomerEntity;
import com.tech_challange.grupo35.user.entity.RestaurantOwnerEntity;
import com.tech_challange.grupo35.user.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class UserMapper {

    public CustomerEntity toEntity(CreateCustomerRequest request){
        CustomerEntity customer = new CustomerEntity();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setLogin(request.login());
        customer.setAddress(request.address());
        customer.setCpf(request.cpf());
        customer.setLastUpdatedAt(LocalDateTime.now());
        return customer;
    }

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

    public void updateEntity(CustomerEntity entity, UpdateCustomerRequest request) {
        Optional.ofNullable(request.name()).ifPresent(entity::setName);
        Optional.ofNullable(request.email()).ifPresent(entity::setEmail);
        Optional.ofNullable(request.login()).ifPresent(entity::setLogin);
        Optional.ofNullable(request.address()).ifPresent(entity::setAddress);
        Optional.ofNullable(request.cpf()).ifPresent(entity::setCpf);
        entity.setLastUpdatedAt(LocalDateTime.now());
    }

    public void updateEntity(RestaurantOwnerEntity entity, UpdateRestaurantOwnerRequest request) {
        Optional.ofNullable(request.name()).ifPresent(entity::setName);
        Optional.ofNullable(request.email()).ifPresent(entity::setEmail);
        Optional.ofNullable(request.login()).ifPresent(entity::setLogin);
        Optional.ofNullable(request.address()).ifPresent(entity::setAddress);
        Optional.ofNullable(request.cnpj()).ifPresent(entity::setCnpj);
        entity.setLastUpdatedAt(LocalDateTime.now());
    }


    public UserResponse toResponse(UserEntity entity) {

        String cpf = null;
        String cnpj = null;

        if (entity instanceof CustomerEntity customer) {
            cpf = customer.getCpf();
        } else if (entity instanceof RestaurantOwnerEntity owner) {
            cnpj = owner.getCnpj();
        }

        return new UserResponse(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getLogin(),
                entity.getAddress(),
                entity.getLastUpdatedAt(),
                cpf,
                cnpj
        );
    }

}
