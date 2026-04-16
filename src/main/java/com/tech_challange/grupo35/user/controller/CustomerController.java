package com.tech_challange.grupo35.user.controller;

import com.tech_challange.grupo35.user.dto.CreateCustomerRequest;
import com.tech_challange.grupo35.user.dto.UpdateCustomerRequest;
import com.tech_challange.grupo35.user.dto.UserResponse;
import com.tech_challange.grupo35.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> createCustomer(
            @RequestBody @Valid CreateCustomerRequest request) {

        UserResponse response = userService.createCustomer(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserResponse> updateCustomer(
            @PathVariable UUID id,
            @RequestBody @Valid UpdateCustomerRequest request) {

        return ResponseEntity.ok(userService.updateCustomer(id, request));
    }
}
