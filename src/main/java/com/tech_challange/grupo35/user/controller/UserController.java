package com.tech_challange.grupo35.user.controller;


import com.tech_challange.grupo35.user.dto.ChangePasswordRequest;
import com.tech_challange.grupo35.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "Usuários", description = "Endpoints para operações gerais de usuários")
public class UserController {

    private final UserService userService;

    @PatchMapping("/{id}/password")
    @Operation(summary = "Alterar senha do usuário", description = "Altera a senha de um usuário específico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Senha alterada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida - Senha atual inválida ou dados de entrada inválidos")
    })
    public ResponseEntity<Void> changePassword(
            @PathVariable UUID id,
            @RequestBody @Valid ChangePasswordRequest request) {

        userService.changePassword(id, request);

        return ResponseEntity.noContent().build();
    }

    // TODO Pedro   - ISSUE-06: DELETE /{id}
    // TODO Pedro   - ISSUE-06: GET ?name=

}
