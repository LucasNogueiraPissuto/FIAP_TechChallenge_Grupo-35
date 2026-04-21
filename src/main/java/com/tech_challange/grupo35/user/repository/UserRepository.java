package com.tech_challange.grupo35.user.repository;

import com.tech_challange.grupo35.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    boolean existsByEmail(String email);
    boolean existsByLogin(String login);

    // TODO Pedro   - ISSUE-06: findByNomeContainingIgnoreCase
    // TODO Pedro   - ISSUE-07: findByLogin

}
