package com.tech_challange.grupo35.user.repository;

import com.tech_challange.grupo35.user.entity.CustomerEntity;
import com.tech_challange.grupo35.user.entity.UserEntity;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.util.Optional;
import java.util.UUID;

public class CustomerRepositoryImp implements CustomerRepository {

    private final JdbcClient jdbcClient;

    public CustomerRepositoryImp(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Optional<CustomerEntity> findById(UUID id) {
        return this.jdbcClient
                .sql("SELECT c.*, u.name, u.email, u.login, u.password, u.last_updated_at, u.address " +
                        "FROM customers c JOIN users u ON c.id = u.id WHERE c.id = :id")
                .param("id", id)
                .query(CustomerEntity.class)
                .optional();
    }

    @Override
    public boolean existsByCpf(String cpf) {
        return this.jdbcClient
            .sql("SELECT * FROM customers WHERE cpf = :cpf")
            .param("cpf", cpf)
            .query(CustomerEntity.class)
            .optional()
                .isPresent();
    }

    @Override
    public UserEntity save(CustomerEntity customerEntity) {
        this.jdbcClient
            .sql("INSERT INTO users (id, name, email, login, password, last_updated_at, address) VALUES (:id, :name, :email, :login, :password, :lastUpdatedAt, :address)")
            .param("id", customerEntity.getId())
            .param("name", customerEntity.getName())
            .param("email", customerEntity.getEmail())
            .param("login", customerEntity.getLogin())
            .param("password", customerEntity.getPassword())
            .param("lastUpdatedAt", customerEntity.getLastUpdatedAt())
            .param("address", customerEntity.getAddress())
            .update();

        this.jdbcClient
            .sql("INSERT INTO customers (id, cpf) VALUES (:id, :cpf)")
            .param("id", customerEntity.getId())
            .param("cpf", customerEntity.getCpf())
            .update();

        return customerEntity;
    }
}
