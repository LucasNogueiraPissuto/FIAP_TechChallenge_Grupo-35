package com.tech_challange.grupo35.user.controller;

import com.tech_challange.grupo35.user.dto.CreateRestaurantOwnerRequest;
import com.tech_challange.grupo35.user.dto.UserResponse;
import com.tech_challange.grupo35.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    // TODO Conrado - ISSUE-03: createRestaurantOwner
}
