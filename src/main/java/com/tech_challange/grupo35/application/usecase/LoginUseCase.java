package com.tech_challange.grupo35.application.usecase;

import com.tech_challange.grupo35.application.dto.LoginResponse;
import com.tech_challange.grupo35.application.port.TokenService;
import com.tech_challange.grupo35.domain.exception.InvalidPasswordException;
import com.tech_challange.grupo35.domain.exception.UserNotFoundException;
import com.tech_challange.grupo35.domain.model.User;
import com.tech_challange.grupo35.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginUseCase {

    private final UserRepository userRepository;
    private final TokenService tokenService;

    public LoginResponse execute(String login, String password) {
        User user = userRepository.findByLogin(login)
                .orElseThrow(UserNotFoundException::new);

        if (!user.getPassword().equals(password)) {
            throw new InvalidPasswordException();
        }

        return new LoginResponse(tokenService.generateToken(login));
    }
}
