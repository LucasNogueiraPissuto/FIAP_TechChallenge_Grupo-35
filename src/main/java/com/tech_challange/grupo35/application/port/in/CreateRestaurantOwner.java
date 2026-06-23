package com.tech_challange.grupo35.application.port.in;

import com.tech_challange.grupo35.application.dto.CreateRestaurantOwnerRequest;
import com.tech_challange.grupo35.application.dto.UserResponse;

public interface CreateRestaurantOwner {
    UserResponse execute(CreateRestaurantOwnerRequest request);
}
