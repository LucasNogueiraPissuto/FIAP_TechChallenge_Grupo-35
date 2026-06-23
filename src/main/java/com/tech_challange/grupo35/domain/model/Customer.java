package com.tech_challange.grupo35.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Customer extends User {

    private final String cpf;

    public Customer(UUID id, String name, String email, String login, String password,
                    String address, LocalDateTime lastUpdatedAt, UserType userType, String cpf) {
        super(id, name, email, login, password, address, lastUpdatedAt, userType);
        this.cpf = cpf;
    }

    public static Customer create(String name, String email, String login, String password,
                                  String address, String cpf) {
        return new Customer(
                null,
                requireText(name, "name"),
                requireText(email, "email"),
                requireText(login, "login"),
                requireText(password, "password"),
                requireText(address, "address"),
                LocalDateTime.now(),
                null,
                requireText(cpf, "cpf"));
    }

    @Override
    protected User copy(String name, String email, String login, String password,
                        String address, LocalDateTime lastUpdatedAt, UserType userType) {
        return new Customer(getId(), name, email, login, password, address, lastUpdatedAt, userType, cpf);
    }

    public String getCpf() {
        return cpf;
    }
}
