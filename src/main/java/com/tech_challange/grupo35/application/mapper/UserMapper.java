package com.tech_challange.grupo35.application.mapper;

import com.tech_challange.grupo35.application.dto.UserResponse;
import com.tech_challange.grupo35.domain.model.Customer;
import com.tech_challange.grupo35.domain.model.RestaurantOwner;
import com.tech_challange.grupo35.domain.model.User;
import com.tech_challange.grupo35.domain.model.UserType;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponse toResponse(User user) {
        String cpf = null;
        String cnpj = null;

        if (user instanceof Customer customer) {
            cpf = customer.getCpf();
        } else if (user instanceof RestaurantOwner owner) {
            cnpj = owner.getCnpj();
        }

        UserType userType = user.getUserType();

        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getLogin(),
                user.getAddress(),
                user.getLastUpdatedAt(),
                cpf,
                cnpj,
                userType != null ? userType.getId() : null,
                userType != null ? userType.getName() : null
        );
    }
}
