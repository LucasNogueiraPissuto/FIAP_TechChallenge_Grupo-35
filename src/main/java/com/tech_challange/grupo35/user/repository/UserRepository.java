package com.tech_challange.grupo35.user.repository;

import com.tech_challange.grupo35.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository{

    Optional<UserEntity> findById(UUID id);
    boolean existsByEmail(String email);
    boolean existsByLogin (String login);
    Optional<UserEntity> findByName(String name);
    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByLogin(String login);
    List<UserEntity> findAll(int size, int Offset);
    Integer save(UserEntity user);
    Integer update(UserEntity user, UUID id);
    Integer delete(UUID id);
}
