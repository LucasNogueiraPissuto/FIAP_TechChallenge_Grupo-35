package com.tech_challange.grupo35.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateRestaurantOwnerRequest(
        @NotBlank
        String name,

        @Email @NotBlank
        String email,

        @NotBlank
        String login,

        @NotBlank
        String password,

        @NotBlank
        String address,

        @NotBlank
        String cnpj
) {}
