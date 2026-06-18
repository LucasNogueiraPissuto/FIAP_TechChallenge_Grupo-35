package com.tech_challange.grupo35.application.usecase;

import com.tech_challange.grupo35.application.dto.UserResponse;
import com.tech_challange.grupo35.application.mapper.UserMapper;
import com.tech_challange.grupo35.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindUsersByNameUseCase {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserResponse> execute(String name) {
        return userRepository
                .findByNameContainingIgnoreCase(name)
                .stream()
                .map(userMapper::toResponse)
                .toList();
    }
}
