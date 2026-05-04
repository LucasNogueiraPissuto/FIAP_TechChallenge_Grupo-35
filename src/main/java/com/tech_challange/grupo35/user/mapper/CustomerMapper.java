package com.tech_challange.grupo35.user.mapper;

import com.tech_challange.grupo35.user.dto.CreateCustomerRequest;
import com.tech_challange.grupo35.user.dto.UpdateCustomerRequest;
import com.tech_challange.grupo35.user.entity.CustomerEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class CustomerMapper {

    public CustomerEntity toEntity(CreateCustomerRequest request) {
        CustomerEntity customer = new CustomerEntity();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setLogin(request.login());
        customer.setAddress(request.address());
        customer.setCpf(request.cpf());
        customer.setLastUpdatedAt(LocalDateTime.now());
        return customer;
    }

    public void updateEntity(CustomerEntity entity, UpdateCustomerRequest request) {
        Optional.ofNullable(request.name()).ifPresent(entity::setName);
        Optional.ofNullable(request.email()).ifPresent(entity::setEmail);
        Optional.ofNullable(request.login()).ifPresent(entity::setLogin);
        Optional.ofNullable(request.address()).ifPresent(entity::setAddress);
        Optional.ofNullable(request.cpf()).ifPresent(entity::setCpf);
        entity.setLastUpdatedAt(LocalDateTime.now());
    }
}
