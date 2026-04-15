package com.tech_challange.grupo35.user.service;

import com.tech_challange.grupo35.exception.*;
import com.tech_challange.grupo35.user.dto.*;
import com.tech_challange.grupo35.user.entity.CustomerEntity;
import com.tech_challange.grupo35.user.entity.RestaurantOwnerEntity;
import com.tech_challange.grupo35.user.entity.UserEntity;
import com.tech_challange.grupo35.user.mapper.UserMapper;
import com.tech_challange.grupo35.user.repository.CustomerRepository;
import com.tech_challange.grupo35.user.repository.RestaurantOwnerRepository;
import com.tech_challange.grupo35.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final RestaurantOwnerRepository restaurantOwnerRepository;
    private final UserMapper userMapper;

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

        CustomerEntity customer = userMapper.toEntity(request);
        customer.setPassword(request.password());

        return userMapper.toResponse(customerRepository.save(customer));
    }

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

        RestaurantOwnerEntity owner = userMapper.toEntity(request);
        owner.setPassword(request.password());

        return userMapper.toResponse(restaurantOwnerRepository.save(owner));
    }

    public UserResponse updateUser(UUID id, UpdateUserRequest request) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        if (!user.getEmail().equals(request.email())
                && userRepository.existsByEmail(request.email())) {
            throw new EmailAlreadyExistsException(request.email());
        }
        if (!user.getLogin().equals(request.login())
                && userRepository.existsByLogin(request.login())) {
            throw new LoginAlreadyExistsException(request.login());
        }

        userMapper.updateEntity(user, request);

        return userMapper.toResponse(userRepository.save(user));
    }

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
