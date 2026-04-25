package com.tech_challange.grupo35.user.repository;

import com.tech_challange.grupo35.user.entity.UserEntity;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepositoryImp implements UserRepository {
    final JdbcClient jdbcClient;

    public UserRepositoryImp(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Optional<UserEntity> findById(UUID id) {
        return this.jdbcClient
                .sql("SELECT * FROM users WHERE id = :id")
                .param("id", id)
                .query(UserEntity.class)
                .optional();
    }

    @Override
    public Optional<UserEntity> findByName(String name) {
        return this.jdbcClient
                .sql("SELECT * FROM users WHERE name = :name")
                .param("name", name)
                .query(UserEntity.class)
                .optional();
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return this.jdbcClient
                .sql("SELECT * FROM users WHERE email = :email")
                .param("email", email)
                .query(UserEntity.class)
                .optional();
    }

    @Override
    public Optional<UserEntity> findByLogin(String login){
        return this.jdbcClient
                .sql("SELECT * FROM users WHERE login = :login")
                .param("login", login)
                .query(UserEntity.class)
                .optional();
    }

    @Override
    public List<UserEntity> findAll(int size, int Offset) {
        return jdbcClient
                .sql("SELECT * FROM users LIMIT :size OFFSET :offset")
                .param("size", size)
                .param("offset", Offset)
                .query(UserEntity.class)
                .list();

    }

    @Override
    public Integer save(UserEntity user) {
        return jdbcClient
                .sql("INSERT INTO users (name, email, login, password, lastUpdatedAt, address) VALUES (:name, :email, :login, :password, :lastUpdatedAt, :address)")
                .param("name", user.getName())
                .param("email", user.getEmail())
                .param("password", user.getPassword())
                .param("lastUpdatedAt", user.getLastUpdatedAt())
                .param("address", user.getAddress())
                .update();
    }

    @Override
    public Integer update(UserEntity user, UUID id) {
        return jdbcClient
                .sql("UPDATE users SET name = :name, email = :email, login = :login, password = :password, lastUpdatedAt = :lastUpdatedAt, address = :address WHERE id = :id")
                .param("id", id)
                .param("name", user.getName())
                .param("email", user.getEmail())
                .param("login", user.getLogin())
                .param("password", user.getPassword())
                .param("lastUpdatedAt", user.getLastUpdatedAt())
                .param("address", user.getAddress())
                .update();
    }

    @Override
    public Integer delete(UUID id) {
        return this.jdbcClient
                .sql("DELETE FROM users WHERE id = :id")
                .param("id", id)
                .update();
    }

    @Override
    public boolean existsByEmail(String email) {
        return this.jdbcClient.sql("SELECT * FROM users WHERE email = :email")
                .param("email", email)
                .query(UserEntity.class)
                .optional()
                .isPresent();
    }

    @Override
    public boolean existsByLogin(String login) {
        return this.jdbcClient.sql("SELECT * FROM users WHERE login = :login")
                .param("login", login)
                .query(UserEntity.class)
                .optional()
                .isPresent();
    }
}
