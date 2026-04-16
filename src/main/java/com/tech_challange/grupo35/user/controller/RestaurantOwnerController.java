package com.tech_challange.grupo35.user.controller;

import com.tech_challange.grupo35.user.dto.CreateRestaurantOwnerRequest;
import com.tech_challange.grupo35.user.dto.UpdateRestaurantOwnerRequest;
import com.tech_challange.grupo35.user.dto.UserResponse;
import com.tech_challange.grupo35.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/restaurant-owners")
@RequiredArgsConstructor
public class RestaurantOwnerController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> createRestaurantOwner(
            @RequestBody @Valid CreateRestaurantOwnerRequest request) {

        UserResponse response = userService.createRestaurantOwner(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserResponse> updateRestaurantOwner(
            @PathVariable UUID id,
            @RequestBody @Valid UpdateRestaurantOwnerRequest request) {

        return ResponseEntity.ok(userService.updateRestaurantOwner(id, request));
    }
}
