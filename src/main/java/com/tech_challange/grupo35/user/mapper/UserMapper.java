package com.tech_challange.grupo35.user.mapper;

import com.tech_challange.grupo35.user.dto.CreateCustomerRequest;
import com.tech_challange.grupo35.user.dto.CreateRestaurantOwnerRequest;
import com.tech_challange.grupo35.user.dto.UpdateUserRequest;
import com.tech_challange.grupo35.user.dto.UserResponse;
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

    public void updateEntity(UserEntity entity, UpdateUserRequest request) {
        Optional.ofNullable(request.name())
                .ifPresent(entity::setName);
        Optional.ofNullable(request.email())
                .ifPresent(entity::setEmail);
        Optional.ofNullable(request.login())
                .ifPresent(entity::setLogin);
        Optional.ofNullable(request.address())
                .ifPresent(entity::setAddress);

        entity.setLastUpdatedAt(LocalDateTime.now());

        if (entity instanceof CustomerEntity customer && request.cpf() != null) {
            customer.setCpf(request.cpf());
        } else if (entity instanceof RestaurantOwnerEntity owner && request.cnpj() != null) {
            owner.setCnpj(request.cnpj());
        }
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
