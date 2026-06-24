package com.tech_challange.grupo35.application.usecase;

import com.tech_challange.grupo35.application.dto.CreateCustomerRequest;
import com.tech_challange.grupo35.application.dto.UserResponse;
import com.tech_challange.grupo35.application.mapper.CustomerMapper;
import com.tech_challange.grupo35.application.mapper.UserMapper;
import com.tech_challange.grupo35.application.port.in.CreateCustomer;
import com.tech_challange.grupo35.domain.exception.CpfAlreadyExistsException;
import com.tech_challange.grupo35.domain.exception.EmailAlreadyExistsException;
import com.tech_challange.grupo35.domain.exception.LoginAlreadyExistsException;
import com.tech_challange.grupo35.domain.model.Customer;
import com.tech_challange.grupo35.application.port.out.CustomerRepository;
import com.tech_challange.grupo35.application.port.out.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCustomerUseCase implements CreateCustomer {

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final UserMapper userMapper;

    @Override
    public UserResponse execute(CreateCustomerRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new EmailAlreadyExistsException(request.email());
        }
        if (userRepository.existsByLogin(request.login())) {
            throw new LoginAlreadyExistsException(request.login());
        }
        if (customerRepository.existsByCpf(request.cpf())) {
            throw new CpfAlreadyExistsException(request.cpf());
        }

        Customer customer = customerMapper.toModel(request);

        return userMapper.toResponse(customerRepository.save(customer));
    }
}
