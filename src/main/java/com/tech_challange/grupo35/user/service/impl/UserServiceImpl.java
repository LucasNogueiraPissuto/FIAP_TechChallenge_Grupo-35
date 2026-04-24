package com.tech_challange.grupo35.user.service.impl;

import com.tech_challange.grupo35.exception.*;
import com.tech_challange.grupo35.user.dto.*;
import com.tech_challange.grupo35.user.entity.CustomerEntity;
import com.tech_challange.grupo35.user.entity.RestaurantOwnerEntity;
import com.tech_challange.grupo35.user.entity.UserEntity;
import com.tech_challange.grupo35.user.mapper.CustomerMapper;
import com.tech_challange.grupo35.user.mapper.RestaurantOwnerMapper;
import com.tech_challange.grupo35.user.mapper.UserMapper;
import com.tech_challange.grupo35.user.repository.CustomerRepository;
import com.tech_challange.grupo35.user.repository.RestaurantOwnerRepository;
import com.tech_challange.grupo35.user.repository.UserRepository;
import com.tech_challange.grupo35.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final RestaurantOwnerRepository restaurantOwnerRepository;
    private final UserMapper userMapper;
    private final CustomerMapper customerMapper;
    private final RestaurantOwnerMapper restaurantOwnerMapper;

    @Override
    public UserResponse createCustomer(CreateCustomerRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new EmailAlreadyExistsException(request.email());
        }
        if (userRepository.existsByLogin(request.login())) {
            throw new LoginAlreadyExistsException(request.login());
        }
        if (customerRepository.existsByCpf(request.cpf())) {
            throw new CpfAlreadyExistsException(request.cpf());
        }

        CustomerEntity customer = customerMapper.toEntity(request);
        customer.setPassword(request.password());

        return userMapper.toResponse(customerRepository.save(customer));
    }

    @Override
    public UserResponse createRestaurantOwner(CreateRestaurantOwnerRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new EmailAlreadyExistsException(request.email());
        }
        if (userRepository.existsByLogin(request.login())) {
            throw new LoginAlreadyExistsException(request.login());
        }
        if (restaurantOwnerRepository.existsByCnpj(request.cnpj())) {
            throw new CnpjAlreadyExistsException(request.cnpj());
        }

        RestaurantOwnerEntity owner = restaurantOwnerMapper.toEntity(request);
        owner.setPassword(request.password());

        return userMapper.toResponse(restaurantOwnerRepository.save(owner));
    }

    @Override
    public UserResponse updateCustomer(UUID id, UpdateCustomerRequest request) {
        CustomerEntity customer = customerRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        if (request.email() != null
                && !request.email().equals(customer.getEmail())
                && userRepository.existsByEmail(request.email())) {
            throw new EmailAlreadyExistsException(request.email());
        }
        if (request.login() != null
                && !request.login().equals(customer.getLogin())
                && userRepository.existsByLogin(request.login())) {
            throw new LoginAlreadyExistsException(request.login());
        }

        customerMapper.updateEntity(customer, request);
        return userMapper.toResponse(customerRepository.save(customer));
    }

    @Override
    public UserResponse updateRestaurantOwner(UUID id, UpdateRestaurantOwnerRequest request) {
        RestaurantOwnerEntity owner = restaurantOwnerRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        if (request.email() != null
                && !request.email().equals(owner.getEmail())
                && userRepository.existsByEmail(request.email())) {
            throw new EmailAlreadyExistsException(request.email());
        }
        if (request.login() != null
                && !request.login().equals(owner.getLogin())
                && userRepository.existsByLogin(request.login())) {
            throw new LoginAlreadyExistsException(request.login());
        }

        restaurantOwnerMapper.updateEntity(owner, request);
        return userMapper.toResponse(restaurantOwnerRepository.save(owner));
    }

    @Override
    public void changePassword(UUID id, ChangePasswordRequest request) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        if (!user.getPassword().equals(request.currentPassword())) {
            throw new InvalidPasswordException();
        }

        user.setPassword(request.newPassword());
        user.setLastUpdatedAt(LocalDateTime.now());

        userRepository.save(user);
    }

    // TODO Pedro   - ISSUE-06: deleteUser
    // TODO Pedro   - ISSUE-06: findByNome
    // TODO Pedro   - ISSUE-07: login

}
