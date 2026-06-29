package com.tech_challange.grupo35.domain.exception;

import java.util.UUID;

public class InvalidRestaurantOwnerException extends RuntimeException {
    public InvalidRestaurantOwnerException(UUID ownerId) {
        super("Usuário não pode ser dono de restaurante (tipo inválido): " + ownerId);
    }
}
