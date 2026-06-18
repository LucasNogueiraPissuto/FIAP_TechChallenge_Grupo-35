package com.tech_challange.grupo35.application.usecase;

import com.tech_challange.grupo35.application.dto.UserTypeResponse;
import com.tech_challange.grupo35.domain.exception.UserTypeNotFoundException;
import com.tech_challange.grupo35.domain.model.UserType;
import com.tech_challange.grupo35.domain.repository.UserTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetUserTypeByIdUseCase {

    private final UserTypeRepository userTypeRepository;

    public UserTypeResponse execute(UUID id) {
        UserType userType = userTypeRepository.findById(id)
                .orElseThrow(() -> new UserTypeNotFoundException(id));
        return new UserTypeResponse(userType.getId(), userType.getName());
    }
}
