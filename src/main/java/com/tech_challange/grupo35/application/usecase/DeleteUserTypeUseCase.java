package com.tech_challange.grupo35.application.usecase;

import com.tech_challange.grupo35.application.port.in.DeleteUserType;
import com.tech_challange.grupo35.domain.exception.UserTypeNotFoundException;
import com.tech_challange.grupo35.application.port.out.UserTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteUserTypeUseCase implements DeleteUserType {

    private final UserTypeRepository userTypeRepository;

    @Override
    public void execute(UUID id) {
        if (!userTypeRepository.existsById(id)) {
            throw new UserTypeNotFoundException(id);
        }
        userTypeRepository.deleteById(id);
    }
}
