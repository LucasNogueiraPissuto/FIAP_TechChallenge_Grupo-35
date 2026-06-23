package com.tech_challange.grupo35.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class RestaurantOwner extends User {

    private final String cnpj;

    public RestaurantOwner(UUID id, String name, String email, String login, String password,
                           String address, LocalDateTime lastUpdatedAt, UserType userType, String cnpj) {
        super(id, name, email, login, password, address, lastUpdatedAt, userType);
        this.cnpj = cnpj;
    }

    public static RestaurantOwner create(String name, String email, String login, String password,
                                         String address, String cnpj) {
        return new RestaurantOwner(
                null,
                requireText(name, "name"),
                requireText(email, "email"),
                requireText(login, "login"),
                requireText(password, "password"),
                requireText(address, "address"),
                LocalDateTime.now(),
                null,
                requireText(cnpj, "cnpj"));
    }

    @Override
    protected User copy(String name, String email, String login, String password,
                        String address, LocalDateTime lastUpdatedAt, UserType userType) {
        return new RestaurantOwner(getId(), name, email, login, password, address, lastUpdatedAt, userType, cnpj);
    }

    public String getCnpj() {
        return cnpj;
    }
}
