package com.tech_challange.grupo35.application.usecase;

import com.tech_challange.grupo35.application.dto.CreateRestaurantOwnerRequest;
import com.tech_challange.grupo35.application.dto.UserResponse;
import com.tech_challange.grupo35.application.mapper.RestaurantOwnerMapper;
import com.tech_challange.grupo35.application.mapper.UserMapper;
import com.tech_challange.grupo35.application.port.in.CreateRestaurantOwner;
import com.tech_challange.grupo35.domain.exception.CnpjAlreadyExistsException;
import com.tech_challange.grupo35.domain.exception.EmailAlreadyExistsException;
import com.tech_challange.grupo35.domain.exception.LoginAlreadyExistsException;
import com.tech_challange.grupo35.domain.model.RestaurantOwner;
import com.tech_challange.grupo35.domain.repository.RestaurantOwnerRepository;
import com.tech_challange.grupo35.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateRestaurantOwnerUseCase implements CreateRestaurantOwner {

    private final UserRepository userRepository;
    private final RestaurantOwnerRepository restaurantOwnerRepository;
    private final RestaurantOwnerMapper restaurantOwnerMapper;
    private final UserMapper userMapper;

    @Override
    public UserResponse execute(CreateRestaurantOwnerRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new EmailAlreadyExistsException(request.email());
        }
        if (userRepository.existsByLogin(request.login())) {
            throw new LoginAlreadyExistsException(request.login());
        }
        if (restaurantOwnerRepository.existsByCnpj(request.cnpj())) {
            throw new CnpjAlreadyExistsException(request.cnpj());
        }

        RestaurantOwner owner = restaurantOwnerMapper.toModel(request);
        owner.setPassword(request.password());

        return userMapper.toResponse(restaurantOwnerRepository.save(owner));
    }
}
