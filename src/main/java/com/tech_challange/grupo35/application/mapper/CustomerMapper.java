package com.tech_challange.grupo35.application.mapper;

import com.tech_challange.grupo35.application.dto.CreateCustomerRequest;
import com.tech_challange.grupo35.application.dto.UpdateCustomerRequest;
import com.tech_challange.grupo35.domain.model.Customer;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CustomerMapper {

    public Customer toModel(CreateCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setLogin(request.login());
        customer.setPassword(request.password());
        customer.setAddress(request.address());
        customer.setCpf(request.cpf());
        customer.setLastUpdatedAt(LocalDateTime.now());
        return customer;
    }

    public Customer updateModel(Customer current, UpdateCustomerRequest request) {
        if (request.name() != null) current.setName(request.name());
        if (request.email() != null) current.setEmail(request.email());
        if (request.login() != null) current.setLogin(request.login());
        if (request.address() != null) current.setAddress(request.address());
        if (request.cpf() != null) current.setCpf(request.cpf());
        current.setLastUpdatedAt(LocalDateTime.now());
        return current;
    }
}
