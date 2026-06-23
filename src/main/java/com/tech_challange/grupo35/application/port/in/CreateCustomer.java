package com.tech_challange.grupo35.application.port.in;

import com.tech_challange.grupo35.application.dto.CreateCustomerRequest;
import com.tech_challange.grupo35.application.dto.UserResponse;

public interface CreateCustomer {
    UserResponse execute(CreateCustomerRequest request);
}