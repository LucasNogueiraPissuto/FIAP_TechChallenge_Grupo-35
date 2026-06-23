package com.tech_challange.grupo35.infrastructure.persistence.mapper;

import com.tech_challange.grupo35.domain.model.Customer;
import com.tech_challange.grupo35.domain.model.RestaurantOwner;
import com.tech_challange.grupo35.domain.model.User;
import com.tech_challange.grupo35.infrastructure.persistence.entity.CustomerEntity;
import com.tech_challange.grupo35.infrastructure.persistence.entity.RestaurantOwnerEntity;
import com.tech_challange.grupo35.infrastructure.persistence.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Mapper polimórfico para o tipo base {@link User}. Como a hierarquia é JOINED,
 * uma linha de {@code users} é sempre um {@code CustomerEntity} ou um
 * {@code RestaurantOwnerEntity}; o dispatch por subtipo precisa acontecer nas duas
 * direções para preservar {@code cpf}/{@code cnpj} e a tabela correta.
 */
@Component
@RequiredArgsConstructor
public class UserEntityMapper {

    private final CustomerEntityMapper customerMapper;
    private final RestaurantOwnerEntityMapper restaurantOwnerMapper;

    public User toDomain(UserEntity entity) {
        if (entity == null) {
            return null;
        }
        if (entity instanceof CustomerEntity customer) {
            return customerMapper.toDomain(customer);
        }
        if (entity instanceof RestaurantOwnerEntity owner) {
            return restaurantOwnerMapper.toDomain(owner);
        }
        throw new IllegalStateException("Unsupported user entity type: " + entity.getClass().getName());
    }

    public UserEntity toEntity(User domain) {
        if (domain == null) {
            return null;
        }
        if (domain instanceof Customer customer) {
            return customerMapper.toEntity(customer);
        }
        if (domain instanceof RestaurantOwner owner) {
            return restaurantOwnerMapper.toEntity(owner);
        }
        throw new IllegalStateException("Unsupported user domain type: " + domain.getClass().getName());
    }
}
