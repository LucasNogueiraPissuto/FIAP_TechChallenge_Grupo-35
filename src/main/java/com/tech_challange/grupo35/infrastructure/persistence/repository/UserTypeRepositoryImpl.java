package com.tech_challange.grupo35.infrastructure.persistence.repository;

import com.tech_challange.grupo35.domain.model.UserType;
import com.tech_challange.grupo35.domain.repository.UserTypeRepository;
import com.tech_challange.grupo35.infrastructure.persistence.jpa.UserTypeJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserTypeRepositoryImpl implements UserTypeRepository {

    private final UserTypeJpaRepository jpaRepository;

    @Override
    public UserType save(UserType userType) {
        return jpaRepository.save(userType);
    }

    @Override
    public Optional<UserType> findById(UUID id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<UserType> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(UUID id) {
        return jpaRepository.existsById(id);
    }

    @Override
    public boolean existsByName(String name) {
        return jpaRepository.existsByName(name);
    }
}
