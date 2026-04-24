package com.tech_challange.grupo35.user.service;

import com.tech_challange.grupo35.user.dto.*;

import java.util.UUID;

public interface UserService {

    UserResponse createCustomer(CreateCustomerRequest request);

    UserResponse createRestaurantOwner(CreateRestaurantOwnerRequest request);

    UserResponse updateCustomer(UUID id, UpdateCustomerRequest request);

    UserResponse updateRestaurantOwner(UUID id, UpdateRestaurantOwnerRequest request);

    void changePassword(UUID id, ChangePasswordRequest request);

}
