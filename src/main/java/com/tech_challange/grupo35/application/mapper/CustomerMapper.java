package com.tech_challange.grupo35.application.mapper;

import com.tech_challange.grupo35.application.dto.CreateCustomerRequest;
import com.tech_challange.grupo35.application.dto.UpdateCustomerRequest;
import com.tech_challange.grupo35.domain.model.Customer;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CustomerMapper {

    public Customer toModel(CreateCustomerRequest request) {
        return Customer.create(
                request.name(),
                request.email(),
                request.login(),
                request.password(),
                request.address(),
                request.cpf());
    }

    public Customer updateModel(Customer current, UpdateCustomerRequest request) {
        return new Customer(
                current.getId(),
                request.name() != null ? request.name() : current.getName(),
                request.email() != null ? request.email() : current.getEmail(),
                request.login() != null ? request.login() : current.getLogin(),
                current.getPassword(),
                request.address() != null ? request.address() : current.getAddress(),
                LocalDateTime.now(),
                current.getUserType(),
                request.cpf() != null ? request.cpf() : current.getCpf());
    }
}
