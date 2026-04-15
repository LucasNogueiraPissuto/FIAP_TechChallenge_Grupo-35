package com.tech_challange.grupo35.user.repository;

import com.tech_challange.grupo35.user.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<UserEntity> findById(Long id);
    Optional<UserEntity> findByName(String name);
    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByLogin(String login);
    List<UserEntity> findAll(int size, int Offset);
    Integer save(UserEntity user);
    Integer update(UserEntity user, Long id);
    Integer delete(Long id);
}
