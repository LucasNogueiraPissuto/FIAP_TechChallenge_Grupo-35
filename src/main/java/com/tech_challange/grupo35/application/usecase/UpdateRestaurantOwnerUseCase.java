package com.tech_challange.grupo35.application.usecase;

import com.tech_challange.grupo35.application.dto.UpdateRestaurantOwnerRequest;
import com.tech_challange.grupo35.application.dto.UserResponse;
import com.tech_challange.grupo35.application.mapper.RestaurantOwnerMapper;
import com.tech_challange.grupo35.application.mapper.UserMapper;
import com.tech_challange.grupo35.application.port.in.UpdateRestaurantOwner;
import com.tech_challange.grupo35.domain.exception.EmailAlreadyExistsException;
import com.tech_challange.grupo35.domain.exception.LoginAlreadyExistsException;
import com.tech_challange.grupo35.domain.exception.UserNotFoundException;
import com.tech_challange.grupo35.domain.model.RestaurantOwner;
import com.tech_challange.grupo35.domain.repository.RestaurantOwnerRepository;
import com.tech_challange.grupo35.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateRestaurantOwnerUseCase implements UpdateRestaurantOwner {

    private final UserRepository userRepository;
    private final RestaurantOwnerRepository restaurantOwnerRepository;
    private final RestaurantOwnerMapper restaurantOwnerMapper;
    private final UserMapper userMapper;

    @Override
    public UserResponse execute(UUID id, UpdateRestaurantOwnerRequest request) {
        RestaurantOwner owner = restaurantOwnerRepository.findById(id)
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

        restaurantOwnerMapper.updateModel(owner, request);
        return userMapper.toResponse(restaurantOwnerRepository.save(owner));
    }
}
