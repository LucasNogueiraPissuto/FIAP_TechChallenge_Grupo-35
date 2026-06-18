package com.tech_challange.grupo35.application.usecase;

import com.tech_challange.grupo35.domain.exception.UserTypeNotFoundException;
import com.tech_challange.grupo35.domain.repository.UserTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteUserTypeUseCase {

    private final UserTypeRepository userTypeRepository;

    public void execute(UUID id) {
        if (!userTypeRepository.existsById(id)) {
            throw new UserTypeNotFoundException(id);
        }
        userTypeRepository.deleteById(id);
    }
}
