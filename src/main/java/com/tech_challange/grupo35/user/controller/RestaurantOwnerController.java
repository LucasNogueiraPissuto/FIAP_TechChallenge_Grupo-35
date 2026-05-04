package com.tech_challange.grupo35.user.controller;

import com.tech_challange.grupo35.user.dto.CreateRestaurantOwnerRequest;
import com.tech_challange.grupo35.user.dto.UpdateRestaurantOwnerRequest;
import com.tech_challange.grupo35.user.dto.UserResponse;
import com.tech_challange.grupo35.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/restaurant-owners")
@RequiredArgsConstructor
@Tag(name = "Donos de Restaurante", description = "Endpoints para gerenciar donos de restaurante")
public class RestaurantOwnerController {

    private final UserService userService;

    @PostMapping
    @Operation(summary = "Criar um novo dono de restaurante", description = "Cria um novo dono de restaurante com os detalhes fornecidos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Dono de restaurante criado com sucesso"),
            @ApiResponse(responseCode = "409", description = "Conflito - Email, login ou CNPJ já existem"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida - Dados de entrada inválidos")
    })
    public ResponseEntity<UserResponse> createRestaurantOwner(
            @RequestBody @Valid CreateRestaurantOwnerRequest request) {

        UserResponse response = userService.createRestaurantOwner(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Atualizar dados do dono do restaurante", description = "Atualiza os dados de um dono de restaurante existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dono de restaurante atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Dono de restaurante não encontrado"),
            @ApiResponse(responseCode = "409", description = "Conflito - Email ou login já existem"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida - Dados de entrada inválidos")
    })
    public ResponseEntity<UserResponse> updateRestaurantOwner(
            @PathVariable UUID id,
            @RequestBody @Valid UpdateRestaurantOwnerRequest request) {

        return ResponseEntity.ok(userService.updateRestaurantOwner(id, request));
    }
}
