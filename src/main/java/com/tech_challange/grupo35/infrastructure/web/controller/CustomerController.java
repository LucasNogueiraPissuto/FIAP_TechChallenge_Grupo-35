package com.tech_challange.grupo35.infrastructure.web.controller;

import com.tech_challange.grupo35.application.dto.CreateCustomerRequest;
import com.tech_challange.grupo35.application.dto.UpdateCustomerRequest;
import com.tech_challange.grupo35.application.dto.UserResponse;
import com.tech_challange.grupo35.application.port.in.CreateCustomer;
import com.tech_challange.grupo35.application.port.in.UpdateCustomer;
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
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
@Tag(name = "Clientes", description = "Endpoints para gerenciar clientes")
public class CustomerController {

    private final CreateCustomer createCustomerUseCase;
    private final UpdateCustomer updateCustomerUseCase;

    @PostMapping
    @Operation(summary = "Criar um novo cliente", description = "Cria um novo cliente com os detalhes fornecidos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponse.class),
                    examples = @ExampleObject(value = """
                        {
                          "id": "a1b2c3d4-e5f6-7890-abcd-ef1234567890",
                          "name": "João Silva",
                          "email": "joao.silva@email.com",
                          "login": "joaosilva",
                          "address": "Rua das Flores, 100, São Paulo - SP",
                          "lastUpdatedAt": "2024-01-15T10:30:00",
                          "cpf": "123.456.789-00",
                          "cnpj": null
                        }
                        """))),
            @ApiResponse(responseCode = "409", description = "E-mail, login ou CPF já cadastrado",
                content = @Content(mediaType = "application/problem+json",
                    examples = @ExampleObject(value = """
                        {
                          "type": "about:blank",
                          "title": "Email Já Cadastrado",
                          "status": 409,
                          "detail": "O email joao.silva@email.com já está em uso."
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
                            { "campo": "email", "mensagem": "must not be blank" }
                          ]
                        }
                        """)))
    })
    public ResponseEntity<UserResponse> createCustomer(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                        {
                          "name": "João Silva",
                          "email": "joao.silva@email.com",
                          "login": "joaosilva",
                          "password": "senha123",
                          "address": "Rua das Flores, 100, São Paulo - SP",
                          "cpf": "123.456.789-00"
                        }
                        """)))
            @RequestBody @Valid CreateCustomerRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(createCustomerUseCase.execute(request));
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Atualizar dados do cliente", description = "Atualiza os dados de um cliente existente. Todos os campos são opcionais.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente atualizado com sucesso",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponse.class),
                    examples = @ExampleObject(value = """
                        {
                          "id": "a1b2c3d4-e5f6-7890-abcd-ef1234567890",
                          "name": "João Silva Atualizado",
                          "email": "joao.silva@email.com",
                          "login": "joaosilva",
                          "address": "Av. Paulista, 1000, São Paulo - SP",
                          "lastUpdatedAt": "2024-01-15T11:00:00",
                          "cpf": "123.456.789-00",
                          "cnpj": null
                        }
                        """))),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado",
                content = @Content(mediaType = "application/problem+json",
                    examples = @ExampleObject(value = """
                        {
                          "type": "about:blank",
                          "title": "Usuário Não Encontrado",
                          "status": 404,
                          "detail": "Usuário com ID a1b2c3d4-e5f6-7890-abcd-ef1234567890 não encontrado."
                        }
                        """))),
            @ApiResponse(responseCode = "409", description = "E-mail ou login já cadastrado",
                content = @Content(mediaType = "application/problem+json",
                    examples = @ExampleObject(value = """
                        {
                          "type": "about:blank",
                          "title": "Email Já Cadastrado",
                          "status": 409,
                          "detail": "O email joao.silva@email.com já está em uso."
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
    public ResponseEntity<UserResponse> updateCustomer(
            @PathVariable UUID id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                        {
                          "name": "João Silva Atualizado",
                          "address": "Av. Paulista, 1000, São Paulo - SP"
                        }
                        """)))
            @RequestBody @Valid UpdateCustomerRequest request) {

        return ResponseEntity.ok(updateCustomerUseCase.execute(id, request));
    }
}
