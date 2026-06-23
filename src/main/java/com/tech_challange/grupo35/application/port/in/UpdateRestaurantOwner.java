package com.tech_challange.grupo35.application.port.in;

import com.tech_challange.grupo35.application.dto.UpdateRestaurantOwnerRequest;
import com.tech_challange.grupo35.application.dto.UserResponse;

import java.util.UUID;

public interface UpdateRestaurantOwner {
    UserResponse execute(UUID id, UpdateRestaurantOwnerRequest request);
}
