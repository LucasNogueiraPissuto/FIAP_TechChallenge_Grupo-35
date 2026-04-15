package com.tech_challange.grupo35.user.service;

import com.tech_challange.grupo35.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // TODO Conrado - ISSUE-03: createCustomer
    // TODO Conrado - ISSUE-03: createRestaurantOwner
    // TODO Conrado - ISSUE-04: updateUser
    // TODO Conrado - ISSUE-05: changePassword
    // TODO Pedro   - ISSUE-06: deleteUser
    // TODO Pedro   - ISSUE-06: findByNome
    // TODO Pedro   - ISSUE-07: login

}
