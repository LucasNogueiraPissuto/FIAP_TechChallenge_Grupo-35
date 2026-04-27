package com.tech_challange.grupo35.user.controller;


import com.tech_challange.grupo35.user.dto.ChangePasswordRequest;
import com.tech_challange.grupo35.user.service.UserService;
import com.tech_challange.grupo35.user.dto.UserResponse;
import com.tech_challange.grupo35.security.dto.LoginRequest;
import com.tech_challange.grupo35.security.dto.LoginResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.List;

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

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar usuário", description = "Remove um usuário pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Usuário deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @Operation(summary = "Buscar usuários por nome", description = "Retorna usuários cujo nome contenha o valor informado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    })
    public ResponseEntity<List<UserResponse>> findByName(
            @RequestParam String name) {
        return ResponseEntity.ok(userService.findByName(name));
    }

    @PostMapping("/login")
    @Operation(summary = "Login de usuário", description = "Autentica e retorna um token JWT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login realizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Login ou senha inválidos")
    })
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(userService.login(request.login(), request.password()));
    }

}
