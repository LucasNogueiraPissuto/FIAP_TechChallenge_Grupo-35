package com.tech_challange.grupo35.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class User {

    private final UUID id;
    private final String name;
    private final String email;
    private final String login;
    private final String password;
    private final String address;
    private final LocalDateTime lastUpdatedAt;
    private final UserType userType;

    protected User(UUID id, String name, String email, String login, String password,
                   String address, LocalDateTime lastUpdatedAt, UserType userType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.login = login;
        this.password = password;
        this.address = address;
        this.lastUpdatedAt = lastUpdatedAt;
        this.userType = userType;
    }

    /**
     * Recria a instância concreta (Customer/RestaurantOwner) preservando os campos
     * específicos do subtipo. Base para as cópias imutáveis.
     */
    protected abstract User copy(String name, String email, String login, String password,
                                 String address, LocalDateTime lastUpdatedAt, UserType userType);

    public User withPassword(String newPassword) {
        return copy(name, email, login, requireText(newPassword, "password"),
                address, LocalDateTime.now(), userType);
    }

    public User withUserType(UserType newUserType) {
        return copy(name, email, login, password, address, lastUpdatedAt, newUserType);
    }

    protected static String requireText(String value, String field) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(field + " is required");
        }
        return value;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public LocalDateTime getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public UserType getUserType() {
        return userType;
    }
}
