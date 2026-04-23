package com.tech_challange.grupo35.user.mapper;

import com.tech_challange.grupo35.user.dto.UserResponse;
import com.tech_challange.grupo35.user.entity.CustomerEntity;
import com.tech_challange.grupo35.user.entity.RestaurantOwnerEntity;
import com.tech_challange.grupo35.user.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

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
