package com.tech_challange.grupo35.domain.model;

import java.util.UUID;

public class UserType {

    private final UUID id;
    private final String name;

    public UserType(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public static UserType create(String name) {
        return new UserType(null, requireText(name, "name"));
    }

    public UserType withName(String newName) {
        return new UserType(id, requireText(newName, "name"));
    }

    private static String requireText(String value, String field) {
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
}
