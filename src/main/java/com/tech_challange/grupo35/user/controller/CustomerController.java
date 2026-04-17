package com.tech_challange.grupo35.user.controller;

import com.tech_challange.grupo35.user.dto.CreateCustomerRequest;
import com.tech_challange.grupo35.user.dto.UpdateCustomerRequest;
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
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
@Tag(name = "Clientes", description = "Endpoints para gerenciar clientes")
public class CustomerController {
    private final UserService userService;

    @PostMapping
    @Operation(summary = "Criar um novo cliente", description = "Cria um novo cliente com os detalhes fornecidos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso"),
            @ApiResponse(responseCode = "409", description = "Conflito - Email, login ou CPF já existem"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida - Dados de entrada inválidos")
    })
    public ResponseEntity<UserResponse> createCustomer(
            @RequestBody @Valid CreateCustomerRequest request) {

        UserResponse response = userService.createCustomer(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Atualizar dados do cliente", description = "Atualiza os dados de um cliente existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado"),
            @ApiResponse(responseCode = "409", description = "Conflito - Email ou login já existem"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida - Dados de entrada inválidos")
    })
    public ResponseEntity<UserResponse> updateCustomer(
            @PathVariable UUID id,
            @RequestBody @Valid UpdateCustomerRequest request) {

        return ResponseEntity.ok(userService.updateCustomer(id, request));
    }
}
