package com.tech_challange.grupo35.user.dto;

import jakarta.validation.constraints.NotBlank;

public record ChangePasswordRequest(
        @NotBlank
        String currentPassword,

        @NotBlank
        String newPassword
) {}
