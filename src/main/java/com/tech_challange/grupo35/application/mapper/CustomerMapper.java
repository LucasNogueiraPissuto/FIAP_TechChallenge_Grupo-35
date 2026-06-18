package com.tech_challange.grupo35.application.mapper;

import com.tech_challange.grupo35.application.dto.CreateCustomerRequest;
import com.tech_challange.grupo35.application.dto.UpdateCustomerRequest;
import com.tech_challange.grupo35.domain.model.Customer;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class CustomerMapper {

    public Customer toModel(CreateCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setLogin(request.login());
        customer.setAddress(request.address());
        customer.setCpf(request.cpf());
        customer.setLastUpdatedAt(LocalDateTime.now());
        return customer;
    }

    public void updateModel(Customer customer, UpdateCustomerRequest request) {
        Optional.ofNullable(request.name()).ifPresent(customer::setName);
        Optional.ofNullable(request.email()).ifPresent(customer::setEmail);
        Optional.ofNullable(request.login()).ifPresent(customer::setLogin);
        Optional.ofNullable(request.address()).ifPresent(customer::setAddress);
        Optional.ofNullable(request.cpf()).ifPresent(customer::setCpf);
        customer.setLastUpdatedAt(LocalDateTime.now());
    }
}
