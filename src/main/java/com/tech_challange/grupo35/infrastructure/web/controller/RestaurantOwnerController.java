package com.tech_challange.grupo35.infrastructure.web.controller;

import com.tech_challange.grupo35.application.dto.CreateRestaurantOwnerRequest;
import com.tech_challange.grupo35.application.dto.UpdateRestaurantOwnerRequest;
import com.tech_challange.grupo35.application.dto.UserResponse;
import com.tech_challange.grupo35.application.usecase.CreateRestaurantOwnerUseCase;
import com.tech_challange.grupo35.application.usecase.UpdateRestaurantOwnerUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
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

    private final CreateRestaurantOwnerUseCase createRestaurantOwnerUseCase;
    private final UpdateRestaurantOwnerUseCase updateRestaurantOwnerUseCase;

    @PostMapping
    @Operation(summary = "Criar um novo dono de restaurante", description = "Cria um novo dono de restaurante com os detalhes fornecidos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Dono de restaurante criado com sucesso",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponse.class),
                    examples = @ExampleObject(value = """
                        {
                          "id": "b2c3d4e5-f6a7-8901-bcde-f12345678901",
                          "name": "Maria Oliveira",
                          "email": "maria.oliveira@restaurante.com",
                          "login": "mariaoliveira",
                          "address": "Rua dos Restaurantes, 200, São Paulo - SP",
                          "lastUpdatedAt": "2024-01-15T10:30:00",
                          "cpf": null,
                          "cnpj": "12.345.678/0001-90"
                        }
                        """))),
            @ApiResponse(responseCode = "409", description = "E-mail, login ou CNPJ já cadastrado",
                content = @Content(mediaType = "application/problem+json",
                    examples = @ExampleObject(value = """
                        {
                          "type": "about:blank",
                          "title": "CNPJ Já Cadastrado",
                          "status": 409,
                          "detail": "O CNPJ 12.345.678/0001-90 já está em uso."
                        }
                        """))),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos",
                content = @Content(mediaType = "application/problem+json",
                    examples = @ExampleObject(value = """
                        {
                          "type": "about:blank",
                          "title": "Dados de Entrada Inválidos",
                          "status": 400,
                          "detail": "Um ou mais campos possuem valores inválidos.",
                          "erros": [
                            { "campo": "cnpj", "mensagem": "must not be blank" }
                          ]
                        }
                        """)))
    })
    public ResponseEntity<UserResponse> createRestaurantOwner(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                        {
                          "name": "Maria Oliveira",
                          "email": "maria.oliveira@restaurante.com",
                          "login": "mariaoliveira",
                          "password": "senha123",
                          "address": "Rua dos Restaurantes, 200, São Paulo - SP",
                          "cnpj": "12.345.678/0001-90"
                        }
                        """)))
            @RequestBody @Valid CreateRestaurantOwnerRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(createRestaurantOwnerUseCase.execute(request));
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Atualizar dados do dono do restaurante", description = "Atualiza os dados de um dono de restaurante existente. Todos os campos são opcionais.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dono de restaurante atualizado com sucesso",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponse.class),
                    examples = @ExampleObject(value = """
                        {
                          "id": "b2c3d4e5-f6a7-8901-bcde-f12345678901",
                          "name": "Maria Oliveira Atualizada",
                          "email": "maria.oliveira@restaurante.com",
                          "login": "mariaoliveira",
                          "address": "Av. Brasil, 500, São Paulo - SP",
                          "lastUpdatedAt": "2024-01-15T11:00:00",
                          "cpf": null,
                          "cnpj": "12.345.678/0001-90"
                        }
                        """))),
            @ApiResponse(responseCode = "404", description = "Dono de restaurante não encontrado",
                content = @Content(mediaType = "application/problem+json",
                    examples = @ExampleObject(value = """
                        {
                          "type": "about:blank",
                          "title": "Usuário Não Encontrado",
                          "status": 404,
                          "detail": "Usuário com ID b2c3d4e5-f6a7-8901-bcde-f12345678901 não encontrado."
                        }
                        """))),
            @ApiResponse(responseCode = "409", description = "E-mail ou login já cadastrado",
                content = @Content(mediaType = "application/problem+json",
                    examples = @ExampleObject(value = """
                        {
                          "type": "about:blank",
                          "title": "Email Já Cadastrado",
                          "status": 409,
                          "detail": "O email maria.oliveira@restaurante.com já está em uso."
                        }
                        """))),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos",
                content = @Content(mediaType = "application/problem+json",
                    examples = @ExampleObject(value = """
                        {
                          "type": "about:blank",
                          "title": "Dados de Entrada Inválidos",
                          "status": 400,
                          "detail": "Um ou mais campos possuem valores inválidos.",
                          "erros": [
                            { "campo": "email", "mensagem": "must be a well-formed email address" }
                          ]
                        }
                        """)))
    })
    public ResponseEntity<UserResponse> updateRestaurantOwner(
            @PathVariable UUID id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                        {
                          "name": "Maria Oliveira Atualizada",
                          "address": "Av. Brasil, 500, São Paulo - SP"
                        }
                        """)))
            @RequestBody @Valid UpdateRestaurantOwnerRequest request) {

        return ResponseEntity.ok(updateRestaurantOwnerUseCase.execute(id, request));
    }
}
