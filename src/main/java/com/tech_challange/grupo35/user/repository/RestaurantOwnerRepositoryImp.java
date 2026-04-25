package com.tech_challange.grupo35.user.repository;

import com.tech_challange.grupo35.user.entity.RestaurantOwnerEntity;
import com.tech_challange.grupo35.user.entity.UserEntity;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.util.Optional;
import java.util.UUID;

public class RestaurantOwnerRepositoryImp implements RestaurantOwnerRepository{

    private final JdbcClient jdbcClient;

    public RestaurantOwnerRepositoryImp(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Optional<RestaurantOwnerEntity> findById(UUID id) {
        return this.jdbcClient
                .sql("SELECT r.*, u.name, u.email, u.login, u.password, u.last_updated_at, u.address " +
                        "FROM restaurant_owners r JOIN users u ON r.id = u.id WHERE r.id = :id")
                .param("id", id)
                .query(RestaurantOwnerEntity.class)
                .optional();
    }



    @Override
    public boolean existsByCnpj(String cnpj) {
        return this.jdbcClient.sql("SELECT * FROM restaurant_owners WHERE cnpj = :cnpj")
                .param("cnpj", cnpj)
                .query(RestaurantOwnerEntity.class)
                .optional()
                .isPresent();
    };

    @Override
    public UserEntity save(RestaurantOwnerEntity restaurantOwnerEntity) {
        this.jdbcClient
            .sql("INSERT INTO users (id, name, email, login, password, last_updated_at, address) VALUES (:id, :name, :email, :login, :password, :lastUpdatedAt, :address)")
            .param("id", restaurantOwnerEntity.getId())
            .param("name", restaurantOwnerEntity.getName())
            .param("email", restaurantOwnerEntity.getEmail())
            .param("login", restaurantOwnerEntity.getLogin())
            .param("password", restaurantOwnerEntity.getPassword())
            .param("lastUpdatedAt", restaurantOwnerEntity.getLastUpdatedAt())
            .param("address", restaurantOwnerEntity.getAddress())
            .update();

        this.jdbcClient
            .sql("INSERT INTO restaurant_owners (id, cnpj) VALUES (:id, :cnpj)")
            .param("id", restaurantOwnerEntity.getId())
            .param("cnpj", restaurantOwnerEntity.getCnpj())
            .update();

        return restaurantOwnerEntity;
    }
}
