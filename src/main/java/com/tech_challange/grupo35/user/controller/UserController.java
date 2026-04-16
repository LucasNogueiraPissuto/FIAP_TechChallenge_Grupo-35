package com.tech_challange.grupo35.user.controller;


import com.tech_challange.grupo35.user.dto.ChangePasswordRequest;
import com.tech_challange.grupo35.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PatchMapping("/{id}/password")
    public ResponseEntity<Void> changePassword(
            @PathVariable UUID id,
            @RequestBody @Valid ChangePasswordRequest request) {

        userService.changePassword(id, request);

        return ResponseEntity.noContent().build();
    }

    // TODO Pedro   - ISSUE-06: DELETE /{id}
    // TODO Pedro   - ISSUE-06: GET ?name=

}
