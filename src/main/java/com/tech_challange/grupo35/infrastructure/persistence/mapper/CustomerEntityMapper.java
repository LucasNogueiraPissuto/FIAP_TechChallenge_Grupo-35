package com.tech_challange.grupo35.infrastructure.persistence.mapper;

import com.tech_challange.grupo35.domain.model.Customer;
import com.tech_challange.grupo35.infrastructure.persistence.entity.CustomerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerEntityMapper {

    private final UserTypeEntityMapper userTypeMapper;

    public Customer toDomain(CustomerEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Customer(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getLogin(),
                entity.getPassword(),
                entity.getAddress(),
                entity.getLastUpdatedAt(),
                userTypeMapper.toDomain(entity.getUserType()),
                entity.getCpf());
    }

    public CustomerEntity toEntity(Customer domain) {
        if (domain == null) {
            return null;
        }
        CustomerEntity entity = new CustomerEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        entity.setEmail(domain.getEmail());
        entity.setLogin(domain.getLogin());
        entity.setPassword(domain.getPassword());
        entity.setAddress(domain.getAddress());
        entity.setLastUpdatedAt(domain.getLastUpdatedAt());
        entity.setUserType(userTypeMapper.toEntity(domain.getUserType()));
        entity.setCpf(domain.getCpf());
        return entity;
    }
}
