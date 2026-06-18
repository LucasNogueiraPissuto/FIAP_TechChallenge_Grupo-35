package com.tech_challange.grupo35.domain.exception;

import java.util.UUID;

public class UserTypeNotFoundException extends RuntimeException {
    public UserTypeNotFoundException(UUID id) {
        super("Tipo de usuário não encontrado com id: " + id);
    }
}
