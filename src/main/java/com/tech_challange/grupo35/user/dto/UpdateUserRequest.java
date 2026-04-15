package com.tech_challange.grupo35.user.dto;

import jakarta.validation.constraints.Email;

public record UpdateUserRequest(

        String name,

        @Email(message = "Formato de e-mail inválido")
        String email,

        String login,

        String address,

        String cpf,

        String cnpj
) {}
