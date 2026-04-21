package com.tech_challange.grupo35.user.dto;

import jakarta.validation.constraints.Email;

public record UpdateCustomerRequest(
        String name,

        @Email
        String email,

        String login,

        String address,

        String cpf
) {}
