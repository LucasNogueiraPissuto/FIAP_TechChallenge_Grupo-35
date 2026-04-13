package com.tech_challange.grupo35.user.mapper;

import com.tech_challange.grupo35.user.dto.UserResponse;
import com.tech_challange.grupo35.user.entity.UserEntity;

public class UserMapper {

    public UserResponse toResponse(UserEntity entity) {
        return new UserResponse(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getLogin(),
                entity.getAddress(),
                entity.getLastUpdatedAt()
        );
    }

}
