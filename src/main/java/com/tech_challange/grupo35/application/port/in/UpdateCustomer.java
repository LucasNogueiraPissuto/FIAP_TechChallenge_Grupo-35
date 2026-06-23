package com.tech_challange.grupo35.application.port.in;

import com.tech_challange.grupo35.application.dto.UpdateCustomerRequest;
import com.tech_challange.grupo35.application.dto.UserResponse;

import java.util.UUID;

public interface UpdateCustomer {
    UserResponse execute(UUID id, UpdateCustomerRequest request);
}
