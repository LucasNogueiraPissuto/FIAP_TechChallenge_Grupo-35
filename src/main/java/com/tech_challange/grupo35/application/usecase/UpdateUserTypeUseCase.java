package com.tech_challange.grupo35.application.usecase;

import com.tech_challange.grupo35.application.dto.UpdateUserTypeRequest;
import com.tech_challange.grupo35.application.dto.UserTypeResponse;
import com.tech_challange.grupo35.domain.exception.UserTypeNameAlreadyExistsException;
import com.tech_challange.grupo35.domain.exception.UserTypeNotFoundException;
import com.tech_challange.grupo35.domain.model.UserType;
import com.tech_challange.grupo35.domain.repository.UserTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateUserTypeUseCase {

    private final UserTypeRepository userTypeRepository;

    public UserTypeResponse execute(UUID id, UpdateUserTypeRequest request) {
        UserType userType = userTypeRepository.findById(id)
                .orElseThrow(() -> new UserTypeNotFoundException(id));

        if (!userType.getName().equals(request.name())
                && userTypeRepository.existsByName(request.name())) {
            throw new UserTypeNameAlreadyExistsException(request.name());
        }

        userType.setName(request.name());
        UserType saved = userTypeRepository.save(userType);
        return new UserTypeResponse(saved.getId(), saved.getName());
    }
}
